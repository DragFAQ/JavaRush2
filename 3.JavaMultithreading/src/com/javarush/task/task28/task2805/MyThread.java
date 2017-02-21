package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger priority = new AtomicInteger(1);

    public MyThread() {
        super();
        setThreadPriority(false);
    }

    public MyThread(Runnable target) {
        super(target);
        setThreadPriority(false);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setThreadPriority(true);
    }

    public MyThread(String name) {
        super(name);
        setThreadPriority(false);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setThreadPriority(true);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setThreadPriority(false);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setThreadPriority(true);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setThreadPriority(true);
    }

    private void setThreadPriority (boolean isGroup) {
        if (priority.get() > 10)
            priority.set(1);
        this.setPriority(isGroup ? Math.min(priority.getAndIncrement(), this.getThreadGroup().getMaxPriority()) : priority.getAndIncrement());
    }
}
