package com.edu.homework.t06;

public class Father extends Grand {
    String id = "001";
    private double score;
    public void f1() {
        System.out.println("super.name = " + super.name);
        super.g1();

        System.out.println("this.id = " + this.id);
        System.out.println("this.name = " + this.name);
        System.out.println("this.score = " + this.score);
        this.g1();
//        this.f1();
    }
}
