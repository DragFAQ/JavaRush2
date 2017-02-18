package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private Path rootPath;
    private List<Path> fileList;

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        fileList = new ArrayList<>();
    }

    public List<Path> getFileList() {
        return fileList;
    }

    public void collectFileList(Path path) throws IOException {
        if (Files.isRegularFile(path))
            path.
    }
}
