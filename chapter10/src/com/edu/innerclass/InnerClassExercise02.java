package com.edu.innerclass;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        new Phone().alarmClock(new Bell() { // 传入匿名内部类
            @Override
            public void ring() { // 重写接口方法
                System.out.println("懒猪起床了");
            }
        });
        new Phone().alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}

interface Bell { // 接口
    void ring(); // 抽象方法
}

class Phone {
    public void alarmClock(Bell bell) { // 形参是接口类型
        bell.ring(); // 动态绑定
    }
}