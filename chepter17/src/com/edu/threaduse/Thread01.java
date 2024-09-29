package com.edu.threaduse;

/**
 * 通过继承Thread类 创建线程
 * 进程 => 启动 main 线程 => 启动 Thread-0 线程
 * main 主线程 启动一个 子线程 后,主线程不会阻塞,会继续执行
 * 主线程与子线程会交替执行
 * 单核CPU并发,多核CPU并行
 * 管理员身份运行 IDEA ,控制台输入 jconsole 监控线程
 * main线程退出后 Thread-0还在继续执行,Thread-0结束后无法响应也无法再连接了
 * 多线程任务中,主线程结束后,程序可能仍然还在运行(执行子线程),全部线程结束后才退出进程
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        // Cat 对象可以当作线程使用了
        Cat cat = new Cat();
        // 启动线程 start => start0 (本地native方法,由JVM机调用,底层是 C 或 C++实现)
        // 真正实现多线程的是 start0 方法,而不是 run
        // start方法调用了start0方法后,该线程并不一定会立马执行,只是将线程变成了 可运行状态
        // 具体执行时间,取决于CPU,由CPU统一调度
        cat.start(); // start会调用run
        // cat.run();
        // run方法只是一个普通的方法,直接调用run方法还是在主线程中,并没有新开一个线程
        // main线程会阻塞在这里,在执行完毕run之后才继续执行后面的代码
        // 串行化 的执行,不再是多线程
        new Cat().start(); // 又开一个线程 Thread-1
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程" + i + Thread.currentThread().getName()); // main
            Thread.sleep(1000);
        }

//        while (true) { // 这样写的话不需要线程类
//            cat.run();
//        }
    }
}

// 当一个类继承了 Thread ,该类就可以当作线程使用
// 重写 run  写上自己的业务逻辑
// run 方法是 Thread 类实现了Runnable 接口的run方法
/*
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
 */
class Cat extends Thread {
    private int times = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("喵喵" + ++times + "线程名 = " + Thread.currentThread().getName()); // Thread-0
            // 让该线程休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            new Cat().start(); // 子线程可以再开子线程
            if (times == 80) break;
        }
    }
}