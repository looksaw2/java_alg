package org.looksaw.Multithread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitNotify {
    private static  boolean flag = true;
    private static  Object lock = new Object();

    public static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock){
                while(flag){
                    try{
                        System.out.println(Thread.currentThread() +
                                " flag is true. wait @" +
                                new SimpleDateFormat("HH:mm:ss").format(new Date())
                        );
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread() +
                        "flag is false. running @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
    public static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread() + "hold lock. notify @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }
            synchronized (lock){
                System.out.println(Thread.currentThread() + "hold lock again. sleep @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }

    public static void main(String[] args){
        Thread WaitThread = new Thread(new Wait() , "WaitThread");
        Thread NotifyThread = new Thread(new Notify() , "NotifyThread");
        WaitThread.start();
        SleepUtils.second(1);
        NotifyThread.start();
    }
}
