package com.edu.method;

public class ThreadMethod_ {
    public static void main(String[] args) throws InterruptedException {
        T200 t200 = new T200();
        Thread thread = new Thread(t200);
        thread.setName("200斤");
        thread.setPriority(Thread.MIN_PRIORITY); // 设置线程优先级
        thread.start();

        Thread.sleep(5000);
        thread.interrupt(); // 提前结束休眠
        System.out.println(thread.getName() + "的优先级是" + thread.getPriority()); // 1
    }
}

class T200 implements Runnable {

    @Override
    public void run() {
        Thread.currentThread().setName("T200线程");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "吃包子" + i);
        }
        try {
            System.out.println(Thread.currentThread().getName() + "休眠中...");
            Thread.sleep(20000);
            System.out.println(Thread.currentThread().getName() + "正常休眠结束");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断");
        }
        System.out.println(Thread.currentThread().getName() + "继续执行");
    }
}