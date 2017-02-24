package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void exit() {
        System.exit(0);
    }

    public Controller(View view) {
        this.view = view;
    }

    public void init() {

    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument() {
        if (document != null) {
            UndoListener listener = view.getUndoListener();
            document.removeUndoableEditListener(listener);

            HTMLEditorKit kit = new HTMLEditorKit();
            document = (HTMLDocument) kit.createDefaultDocument();
            document.addUndoableEditListener(listener);
            view.update();
        }
    }
}

