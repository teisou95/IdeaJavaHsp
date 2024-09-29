package com.edu.homework.t06;

public class Son extends Father {
    String name = "BB";
    public void g1(){}
    public void show() {
        System.out.println("super.name = " + super.name);
        System.out.println("super.id = " + super.id);
        super.f1();
        super.g1();


        System.out.println("this.name = " + this.name);
        System.out.println("this.id = " + this.id);
        this.g1();
//        this.show();
        this.f1();
    }
}
