package org.looksaw.Multithread;

public class Synch {
    public static synchronized void m(){

    }

    public static void main(String[] args){
        synchronized (Synch.class){
            m();
        }
    }
}
