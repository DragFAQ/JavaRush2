package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        State lastState = null;
        do {
            if (target.getState() != lastState) {
                System.out.println(target.getState().name());
                lastState = target.getState();
            }
        }
        while (target.getState() != State.TERMINATED);
    }
}
