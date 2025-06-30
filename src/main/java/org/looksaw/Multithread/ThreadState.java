package org.looksaw.Multithread;

public class ThreadState {
    public static class TimeWaiting implements Runnable {

        @Override
        public void run() {
            while(true) {
                SleepUtils.second(100);
            }
        }
    }

    public static class Waiting implements Runnable {

        @Override
        public void run() {
            synchronized (Waiting.class){
                try {
                    Waiting.class.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }


    public static class Blocked implements Runnable {

        @Override
        public void run() {
            synchronized (Blocked.class){
                while (true){
                    SleepUtils.second(100);
                }
            }
        }
    }
    public static void main(String[] args){
        new Thread(new TimeWaiting(),"TimeWaiting").start();
        new Thread(new Waiting(),"Waiting").start();
        new Thread(new Blocked(),"Blocked-thread1").start();
        new Thread(new Blocked(),"Blocked-thread2").start();
    }
}
