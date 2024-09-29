package com.edu.homework.t05;

public class Homework05 {
    public static void main(String[] args) {
        Teacher king = new Teacher("king", 6000, 225, 20);
        Scientist wang = new Scientist("wang", 20000, 50000);
        Waiter jack = new Waiter("jack", 3500);
        Worker tom = new Worker("tom", 2500);
        tom.setSalMonth(16);
        Peasant mary = new Peasant("mary", 5000);

        System.out.println("老师 " + king.getName() + " 的年收入是 " + king.yearSal());
        System.out.println("科学家 " + wang.getName() + " 的年收入是 " + wang.yearSal());
        System.out.println("服务员 " + jack.getName() + " 的年收入是 " + jack.yearSal());
        System.out.println("工人 " + tom.getName() + " 的年收入是 " + tom.yearSal());
        System.out.println("农民 " + mary.getName() + " 的年收入是 " + mary.yearSal());
    }
}
