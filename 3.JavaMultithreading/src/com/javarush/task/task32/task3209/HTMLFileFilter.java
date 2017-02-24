package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return  (f.isDirectory()) ||
                (f.getName().toUpperCase().lastIndexOf(".HTML") == f.getName().length() - 5) ||
                (f.getName().toUpperCase().lastIndexOf(".HTM") == f.getName().length() - 4);
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
