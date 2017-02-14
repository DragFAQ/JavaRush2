package com.javarush.task.task25.task2508;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        try {
            while (!currentThread().isInterrupted()) {
                System.out.println(currentThread().getName());
                sleep(100);
            }
        } catch (InterruptedException e) {
        }
    }

}
