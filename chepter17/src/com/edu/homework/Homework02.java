package com.edu.homework;

public class Homework02 {
    public static void main(String[] args) {
        Card card = new Card();
        Thread thread1 = new Thread(card);
        Thread thread2 = new Thread(card);

        thread1.setName("jack");
        thread2.setName("tom");

        thread1.start();
        thread2.start();
    }
}

class Card implements Runnable {
    private int money = 10000;
    private int sum = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("钱不够了,余额 " + money + " "
                            + "累计取了 " + sum + "元");
                    break;
                }
                money -= 1000;
                sum += 1000;
                System.out.println(Thread.currentThread().getName() + " 取钱1000元,当前余额 " + money);

                // 休眠放在同步代码块内外,有一定差别,在抢锁的优先上有区别
                // 放内部的话,释放锁后马上重新抢锁,随机性更大
                // 放外部的画,释放锁后休眠,然后再抢锁,落后于其他本类就在等待拿锁的线程,多个线程会呈现轮流进入的情况
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}