package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:");
        for (Operation operation : Operation.values())
            ConsoleHelper.writeMessage(operation.ordinal() + " - " + operation);

        return Operation.values()[ConsoleHelper.readInt()];
    }

    public static void main(String[] args) throws Exception {
        Operation operation;

        while (true) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
                if (operation.equals(Operation.EXIT))
                    break;
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }
/*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String destFile = reader.readLine();
        String sourceFile = reader.readLine();
        reader.close();

        if (!destFile.isEmpty() && !sourceFile.isEmpty()) {
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(destFile));
            zipFileManager.createZip(Paths.get(sourceFile));
        }

        (new ExitCommand()).execute();*/
    }
}
