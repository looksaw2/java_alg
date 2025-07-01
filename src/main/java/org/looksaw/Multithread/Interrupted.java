package org.looksaw.Multithread;

import java.util.concurrent.TimeUnit;

public class Interrupted {
    public static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while(true){
                SleepUtils.second(10);
            }
        }
    }

    public static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while(true){

            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(),"SleepRunner");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(),"BusyRunner");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(sleepThread.isInterrupted());
        System.out.println(busyThread.isInterrupted());
        TimeUnit.SECONDS.sleep(1);

    }
}
