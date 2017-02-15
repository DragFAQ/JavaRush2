package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String result = null;
        boolean success = false;

        while (!success) {
            try {
                result = reader.readLine();
                success = true;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }

        return result;
    }

    public static int readInt() {
        int result = 0;
        boolean success = false;

        while (!success) {
            try {
                result = Integer.parseInt(readString());
                success = true;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибкаn при попытке ввода числа. Попробуйте еще раз.");
            }
        }

        return result;
    }
}
