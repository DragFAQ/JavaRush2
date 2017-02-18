package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String destFile = reader.readLine();
        String sourceFile = reader.readLine();
        reader.close();

        if (!destFile.isEmpty() && !sourceFile.isEmpty()) {
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(destFile));
            zipFileManager.createZip(Paths.get(sourceFile));
        }
    }
}
