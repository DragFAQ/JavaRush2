package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> list = new ArrayList<>();
        while (e != null) {
            list.add(0, e);
            e = e.getCause();
        }

        for (Throwable th : list){
            System.out.println(th);
        }
    }

    public static void main(String[] args) {
        Throwable e =  new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        new Solution().uncaughtException(Thread.currentThread(), e);
    }
}
