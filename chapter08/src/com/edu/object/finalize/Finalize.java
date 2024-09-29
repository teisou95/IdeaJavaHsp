package com.edu.object.finalize;

/**
 * 0326
 * 垃圾回收器确认回收对象前,先调用此方法
 * 子类可以重写,做释放资源的操作
 */
public class Finalize {
    public static void main(String[] args) {
        Car honda = new Car("honda");
        // 当某对象没有任何引用时,JVM就会认为该对象是垃圾对象
        // 会首先调用finalize方法,然后使用垃圾回收机制销毁该对象
        // 对象引用置空,成为垃圾,会被回收(销毁),释放堆中的对象空间,可以被使用(不是马上即时自动回收)
        // 销毁前自动调用的finalize可以被重写,写自己的业务逻辑
        honda = null;

        // 可以通过System.gc()主动触发垃圾回收机制
        System.gc(); // 程序不会等待回收完毕,会继续往下执行
        System.out.println("程序退出了");

    }
}
