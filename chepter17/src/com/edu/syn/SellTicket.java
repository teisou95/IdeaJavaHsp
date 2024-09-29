package com.edu.syn;

/**
 * 模拟三个窗口同时售票,票数总共100张,售完为止,出现"超售"
 * 多个线程共享同一个资源的情况下,会出现线程不同步的情况
 * 使用同步机制解决超售问题
 * 同步的局限性:导致程序效率降低
 */
public class SellTicket {
    public static void main(String[] args) throws InterruptedException {
        Seller seller = new Seller();

        Thread thread1 = new Thread(seller);
        Thread thread2 = new Thread(seller);
        Thread thread3 = new Thread(seller);

        thread1.setName("售票员1 ");
        thread2.setName("售票员2 ");
        thread3.setName("售票员3 ");

        thread1.start();
        thread2.start();
        thread3.start();

        while (true) {
            System.out.println("thread1.getState() = " + thread1.getState());
            System.out.println("thread2.getState() = " + thread2.getState());
            System.out.println("thread3.getState() = " + thread3.getState());
            Thread.sleep(40);
            if (thread1.getState() == Thread.State.TERMINATED
                    && thread2.getState() == Thread.State.TERMINATED
                    && thread3.getState() == Thread.State.TERMINATED) break;
        }
    }
}

// 实现线程同步
class Seller implements Runnable {
    private int ticketNum = 20;
    private int count = 0;
    private boolean loop = true; // 控制循环
    private String str = new String();

    @Override
    public void run() {
//    public synchronized void run() {
        // 方法上锁,同步方法,在同一时刻,只能有一个线程执行同步方法,执行完之后其他线程才能进来
        //      用于此处不合理,所有的票会被第一个进来的售票员卖完
        while (loop) {
            sell(); // 方法加锁
        }
    }

    public synchronized static void m2() {
        // 静态方法或静态方法中的代码块锁在类对象上
    }
    public static void m3() {
        synchronized (SellTicket.class) {
            System.out.println("ccc");
        }
    }

    public /*synchronized*/ void sell() { // 锁在this 对象
        // 非公平锁,同步方法,同时只允许单个线程进入. 互斥锁是在对象上
        // 同步非静态方法的锁可以是 this,也可以是其他对象(要求是同一个对象)
        // 同步静态方法的锁是当前类.class 对象上
        synchronized (str/*this*/){ // 代码块加锁,可以加在this或 其他对象上
            if (ticketNum == 0) {
                loop = false;
                System.out.println("总共售出票数:" + count);
                return;
            }
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
}