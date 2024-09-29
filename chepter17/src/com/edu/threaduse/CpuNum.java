package com.edu.threaduse;

public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime(); // Runtime 是单例模式
        // 当前电脑可用处理器数量
        int cpuNum = runtime.availableProcessors();
        System.out.println(cpuNum + "核处理器");
        // 创建线程两种方式 继承Thread,实现Runnable
        // Thread类本身就实现了 Runnable
    }
}
