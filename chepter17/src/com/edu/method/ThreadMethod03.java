package com.edu.method;

/**
 * 用户线程(工作线程) 和 守护线程(服务线程)
 * 当所有的用户线程结束,守护线程自动结束:如垃圾回收机制
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread thread = new MyDaemonThread();
        // 将子线程设置为守护线程,先设置后启动
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main 线程执行中...");
            Thread.sleep(1000);
        }
        System.out.println("主线程结束");
    }
}

class MyDaemonThread extends Thread {
    @Override
    public void run() {
        for (; ; ) { // 无限循环
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("无限哈哈哈,等主线程结束我就退出");
        }
    }
}