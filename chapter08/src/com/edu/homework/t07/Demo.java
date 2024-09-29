package com.edu.homework.t07;

public class Demo extends Test {
    String name = "Jack";

    public Demo() {
        System.out.println("Deomo");
    }

    public Demo(String s) {
        super(s);
    }
    public void test() {
        System.out.println(super.name);
        System.out.println(this.name);
    }
}
