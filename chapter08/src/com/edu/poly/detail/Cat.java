package com.edu.poly.detail;

public class Cat extends Animal {
    String color = "黑色";
    int age = 20;
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }
}