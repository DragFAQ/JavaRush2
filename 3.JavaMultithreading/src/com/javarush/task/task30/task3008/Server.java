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
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        ConsoleHelper.writeMessage("Сервер запущен.");
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    (new Handler(socket)).start();
                } finally {
                    socket.close();
                }
            }
        } catch (Exception e){
            serverSocket.close();
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String result = null;
            boolean success = false;

            while (!success) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message response = connection.receive();
                if (response.getType() == MessageType.USER_NAME) {
                    result = connection.receive().getData();
                    //result != null &&
                        if (!result.equals("")) {
                            if (!connectionMap.containsKey(result)) {
                                connectionMap.put(result, connection);

                                connection.send(new Message(MessageType.NAME_ACCEPTED));

                                success = true;
                            }
                        }
                    }
                }


            return result;
        }
    }
}
