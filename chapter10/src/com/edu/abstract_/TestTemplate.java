package com.edu.abstract_;

import java.time.Duration;
import java.time.LocalTime;

public class TestTemplate {
    public static void main(String[] args) {
        AB aa = new AA();
        aa.calTime();
        AB bb = new BB();
        bb.calTime();
    }
}

class AB {
    public void calTime() {
        long startTime = System.nanoTime();
        jobTime();
        long endTime = System.nanoTime();
        System.out.println("jobTime方法,用时" + (endTime - startTime) + "纳秒");
    }
    public void jobTime() {

    }
}

class AA extends AB{
    @Override
    public void calTime() {
        super.calTime();
    }
    //    public void calTime() {
//        long startTime = System.nanoTime();
//        jobTime();
//        long endTime = System.nanoTime();
//        System.out.println("jobTime方法,用时" + (endTime - startTime) + "纳秒");
//    }

    // 计算任务,1 + 2 + ... + 10000
    public void jobTime() {
////        LocalTime startTime = LocalTime.now();
//        long startTime = System.nanoTime();
////        long startTime = System.currentTimeMillis();
        int sum = 0;
        // 10000.fori 快捷键
        for (int i = 1; i <= 10000; i++) {
            sum += i;
        }
//        LocalTime endTime = LocalTime.now();
//        long endTime = System.nanoTime();
//////        long endTime = System.currentTimeMillis();
        System.out.print("AA类");
    }
}

class BB extends AB {
    @Override
    public void calTime() {
        super.calTime();
    }

    //    public void calTime() {
//        long startTime = System.nanoTime();
//        jobTime();
//        long endTime = System.nanoTime();
//
//    }
    // 计算任务,1 + 2 + ... + 10000
    public void jobTime() {
        int sum = 1;
        int i = 1;
        // 10000.fori 快捷键
        while (i <= 10000) {
            sum += i++;
        }
        System.out.print("BB类");
    }
}