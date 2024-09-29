package com.edu.static_;

public class Child {
    private String name;
    private static int count = 0; // 类变量

    public static int getCount() {
        return count;
    }

    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(name + "加入了游戏");
        count++;
    }
}
