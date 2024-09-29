package com.edu.syn;

/**
 * 线程死锁
 * 多个线程都占用了对方的锁资源,不肯相让,导致死锁
 */
public class DeadLock_ {
    public static void main(String[] args) throws InterruptedException {
        DeadLockDemo demo1 = new DeadLockDemo(true);
        DeadLockDemo demo2 = new DeadLockDemo(false);
        demo1.setName("demo1");
        demo2.setName("demo2");

        demo1.start();
        demo2.start();
        // 可能出现:两个线程互相持有对方需要的对象锁,形成死锁,两个线程都一直处于BLOCKED状态,无法结束
        // 也可能不形成死锁:如果某个线程抢先拿到o1 o2 两个锁,结束自己的线程,再释放两把锁,另一个也就可以进去了

        for (int i = 0; i < 20; i++) {
            System.out.println("demo1.getState() = " + demo1.getState());
            System.out.println("demo2.getState() = " + demo2.getState());
            Thread.sleep(500);
        }

    }
}
class DeadLockDemo extends Thread {
    static Object o1 = new Object(); // 保证多个线程共享一个对象
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) { //对象互斥锁,持有 o1 的锁资源
                System.out.println(Thread.currentThread().getName() + " 进入1");
                synchronized (o2) { // 持有 o2 的锁资源,如果拿不到 o2 锁就会进入 BLOCK(等待拿锁) 状态,阻塞
                    System.out.println(Thread.currentThread().getName() + " 进入2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " 进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " 进入4");
                }
            }
        }
    }
}
