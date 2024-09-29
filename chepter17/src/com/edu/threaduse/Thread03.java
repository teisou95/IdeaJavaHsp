package com.edu.threaduse;
//
public class Thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start(); // 启动子线程0
        thread2.start(); // 启动子线程1
    }
}

class T1 implements Runnable {
    private int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hello,world " + (++count) +" " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 60) break;
        }
    }
}

class T2 implements Runnable {
    private int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hi " + (++count) + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 80) break;
        }
    }
}