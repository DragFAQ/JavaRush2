package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message.contains(": ")) {
                String[] str = message.split(": ");
                String response = "Информация для " + str[0] + ": ";
                SimpleDateFormat simpleDateFormat = null;
                if ("дата".equals(str[1])) {
                    simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                } else if ("день".equals(str[1])) {
                    simpleDateFormat = new SimpleDateFormat("d");
                } else if ("месяц".equals(str[1])) {
                    simpleDateFormat = new SimpleDateFormat("MMMM");
                } else if ("год".equals(str[1])) {
                    simpleDateFormat = new SimpleDateFormat("YYYY");
                } else if ("время".equals(str[1])) {
                    simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                } else if ("час".equals(str[1])) {
                    simpleDateFormat = new SimpleDateFormat("H");
                } else if ("минуты".equals(str[1])) {
                    simpleDateFormat = new SimpleDateFormat("m");
                } else if ("секунды".equals(str[1])) {
                    simpleDateFormat = new SimpleDateFormat("s");
                }
                if (simpleDateFormat != null) {
                    response += simpleDateFormat.format(Calendar.getInstance().getTime());
                    sendTextMessage(response);
                }
            }
        }
    }
}
