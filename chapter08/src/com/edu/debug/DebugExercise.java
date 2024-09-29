package com.edu.debug;

public class DebugExercise {
    public static void main(String[] args) {
        Person wang = new Person("wang", 30, 24320);
        /*
         * 追踪创建对象的流程
         * 加载类信息-默认初始化-显式初始化-构造器初始化-返回对象地址
         */
        System.out.println(wang);
        wang.setAge(35);
        wang.setSal(34000);
        System.out.println(wang);
    }
}
