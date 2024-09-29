package com.edu.threaduse;

/**
 * 模拟三个窗口同时售票,票数总共100张,售完为止,出现"超售"
 * 多个线程共享同一个资源的情况下,会出现线程不同步的情况
 */
public class SellTicket {
    public static void main(String[] args) {
        SellTicket01 sellticket01 = new SellTicket01();
        SellTicket01 sellticket02 = new SellTicket01();
        SellTicket01 sellticket03 = new SellTicket01();
        sellticket01.start();
        sellticket02.start();
        sellticket03.start();

//        // 换使用 实现 Runnable 接口的形式
//        SellTickeck02 sellTickeck021 = new SellTickeck02();
//        SellTickeck02 sellTickeck022 = new SellTickeck02();
//        SellTickeck02 sellTickeck023 = new SellTickeck02();
//        Thread thread1 = new Thread(sellTickeck021);
//        Thread thread2 = new Thread(sellTickeck022);
//        Thread thread3 = new Thread(sellTickeck023);
//        thread1.start();
//        thread2.start();
//        thread3.start();

//        SellTickeck02 sellTickeck = new SellTickeck02();
//        Thread thread1 = new Thread(sellTickeck);
//        Thread thread2 = new Thread(sellTickeck);
//        Thread thread3 = new Thread(sellTickeck);
//        thread1.start();
//        thread2.start();
//        thread3.start();
    }
}

class SellTicket01 extends Thread {
    private static int ticketNum = 20;
    private int count = 0;
    private static Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (obj){
                if (ticketNum <= 0)break;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "售出一张票,编号为 "
                        + (21 - (ticketNum--)) + "剩余票数" + ticketNum);
                count++;
            }
        }
        System.out.println(Thread.currentThread().getName() + "总共售出票数:" + count);
    }
}

class SellTickeck02 implements Runnable {
    private static int ticketNum = 20;
    private int count = 0;
    private static Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (obj){
                if (ticketNum <= 0)break;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "售出一张票,编号为 "
                        + (21 - (ticketNum--)) + "剩余票数" + ticketNum);
                count++;
            }
        }
        System.out.println("总共售出票数:" + count);
    }
}