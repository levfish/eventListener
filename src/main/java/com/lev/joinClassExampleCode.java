package com.lev;

/**
 * Created by Lev on 10/26/2018.
 */
public class joinClassExampleCode {
    public static void main(String args[]) {
        Thread t1 = new Thread(()-> System.out.println("Thread 1"));
        t1.start();
        Thread t2 = new Thread(()-> System.out.println("Thread 2"));
        t2.start();

        while (true) {
            try {
                t1.join(); // 1. main thread waits for this to finish..
                t2.join(); // 2. main thread waits for this to finish..
                break;
            }
            catch (InterruptedException e){}
        }

    }
}
