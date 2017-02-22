package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> map : connectionMap.entrySet()) {
            try {
                map.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Сервер запущен.");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler thread = new Handler(socket);
                thread.start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            }
            if (userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    if (message.getData() != null && !message.getData().isEmpty()) {
                        if (!connectionMap.containsKey(message.getData())) {
                            connectionMap.put(message.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return message.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> map : connectionMap.entrySet()) {
                if (!userName.equals(map.getKey()))
                    connection.send(new Message(MessageType.USER_ADDED, map.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message response = connection.receive();

                if (response != null && response.getType() == MessageType.TEXT) {
                    String text = response.getData();
                    Message message = new Message(MessageType.TEXT, userName + ": " + text);
                    sendBroadcastMessage(message);
                } else {
                    ConsoleHelper.writeMessage("Error!");
                }
            }
        }
    }
}
