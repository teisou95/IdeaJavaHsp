package com.edu.exit_;

/**
 * 在主线程中中断子线程
 */
public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T100 t100 = new T100();
        Thread thread = new Thread(t100);
        thread.start(); // 子线程启动
        thread.setName("T100");
        // main 线程休眠
        System.out.println("mian 线程休眠中");
        Thread.sleep(1000);
        t100.setLoop(false); // 终止子线程
        System.out.println("main 线程继续执行...");
    }
}

class T100 implements Runnable {
    private boolean loop = true; // 循环条件

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        int i = 0;
        while (loop) {
            System.out.println("hello" + ++i + Thread.currentThread().getName());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}