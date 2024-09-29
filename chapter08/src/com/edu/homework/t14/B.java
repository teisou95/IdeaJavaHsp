package com.edu.homework.t14;

public class B extends A{
    public B() {
        System.out.println("B类无参构造");
    }
    public B(String name) { // 3
//        super(); // 4
        System.out.println(name + "B类有参构造"); // 6
    }
}
