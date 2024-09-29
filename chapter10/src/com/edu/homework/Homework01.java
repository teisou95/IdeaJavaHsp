package com.edu.homework;

public class Homework01 {
    public static void main(String[] args) {
        Car car = new Car();
        Car car1 = new Car(100);
        System.out.println(car); // 9.0 red
        System.out.println(car1); // 100.0 red
    }
}

class Car {
    double price = 10;
    static String color = "white";

    @Override
    public String toString() {
        return price + "\t" + color;
    }

    public Car() {
        this.price = 9;
        this.color = "red";
    }

    public Car(double price) {
        this.price = price;
    }
}