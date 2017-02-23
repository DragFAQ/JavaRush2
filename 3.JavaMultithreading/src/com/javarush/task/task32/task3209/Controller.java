package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public static void main(String[] args) {

    }

    public Controller(View view) {
        this.view = view;
    }
}

