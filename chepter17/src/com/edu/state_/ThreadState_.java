package com.edu.state_;

import java.util.Hashtable;

/**
 * 线程状态
 * NEW RUNNABLE(READY RUNNING) TIMED_WAITING WAITING BLOCKED  TERMINATED
 */
public class ThreadState_ {
    public static void main(String[] args) throws InterruptedException {
        T500 t500 = new T500();
        System.out.println("当前子线程状态:" + t500.getState());

        t500.start();
        while (Thread.State.TERMINATED != t500.getState()) {
            System.out.println("当前子线程状态:" + t500.getState());
            Thread.sleep(500);
        }
        System.out.println("当前子线程状态:" + t500.getState());
    }
}

class T500 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}