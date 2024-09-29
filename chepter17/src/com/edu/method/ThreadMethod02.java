package com.edu.method;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T300 t300 = new T300();
        t300.setName("T300线程");
        t300.start();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " hi" + i);
            if (i == 4) t300.join(); // 子线程插队,全部执行完毕后,再回来执行主线程
//            if (i == 4) Thread.yield(); // 礼让失败, 资源完全够用,系统底层判断不需要礼让
        }
    }
}

class T300 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " hello " + i);
        }

    }
}