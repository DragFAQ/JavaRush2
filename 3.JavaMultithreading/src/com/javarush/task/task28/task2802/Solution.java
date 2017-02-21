package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) throws InterruptedException {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        Thread.sleep(1000);
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        private static AtomicInteger pool = new AtomicInteger(0);
        private AtomicInteger thread = new AtomicInteger(0);

        public AmigoThreadFactory() {
            pool.incrementAndGet();
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread result = new Thread(Thread.currentThread().getThreadGroup(), r);

            result.setDaemon(false);
            result.setPriority(5);
            result.setName(Thread.currentThread().getThreadGroup().getName() + "-pool-" + pool + "-thread-" + thread.incrementAndGet());

            return result;
        }
    }
}
