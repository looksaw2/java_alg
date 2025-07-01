package org.looksaw.Multithread;

import java.util.concurrent.TimeUnit;

public class Shutdown {
    public static class Runner implements Runnable {
        private long i;
        private volatile boolean on =  true;
        @Override
        public void run() {
            while(on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Shutting down");
            System.out.println("i is :" + i);
        }

        public void cancel(){
            on = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one,"countThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        Thread countThread2 = new Thread(two,"countThread2");
        countThread2.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();

    }
}
