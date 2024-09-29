package com.edu.homework;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        T100 t100 = new T100();
        T200 t200 = new T200(t100);

        Thread thread1 = new Thread(t100);
        Thread thread2 = new Thread(t200);

        thread1.start();
        thread2.start();
    }
}

class T100 implements Runnable {
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            System.out.println((int)(Math.random() * 101));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("T100 线程退出");
    }
}

class T200 implements Runnable {
    private T100 t100;

    public T200(T100 t100) {
        this.t100 = t100;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入字符,Q代表退出");
            Scanner scanner = new Scanner(System.in);
            char c = scanner.next().charAt(0);
            if (Character.toUpperCase(c) == 'Q') {
                t100.setLoop(false);
                System.out.println("T200 线程退出");
                break;
            }
        }
    }
}