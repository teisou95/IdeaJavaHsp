package com.edu.threaduse;

/**
 *
 * java是单继承机制,也可以通过实现 Runnable接口 开发线程
 *  再通过Thread构造器传入 Runnable 接口对象,代理调用start0方法
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread0 = new Thread(dog);
        thread0.start();
//        dog.run(); // main线程
        // 模拟线程代理
//        Tiger tiger = new Tiger();
//        ThreadProxy threadProxy = new ThreadProxy(tiger);
//        threadProxy.start();
    }
}
class Animal{}
class Tiger extends Animal implements Runnable {

    @Override
    public void run() {
        System.out.println("老虎叫");
    }
}
// 模拟线程代理
class ThreadProxy implements Runnable {
private Runnable target;

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
    public void start() {
        start0(); // Thread.start0 是真正实现多线程的方法
    }
    public void start0() {
        run();
    }
}


class Dog implements Runnable {
    private int times = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("汪汪hi" + (++times) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 10) break;
        }
    }
}