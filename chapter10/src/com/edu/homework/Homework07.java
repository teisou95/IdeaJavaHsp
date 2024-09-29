package com.edu.homework;

public class Homework07 {
    public static void main(String[] args) {
        Car1 car1 = new Car1(45);
        Car1 car11 = new Car1(-2);
        Car1 car12 = new Car1(25);
        car1.getAir().flow();
        car11.getAir().flow();
        car12.getAir().flow();
    }
}
class Car1 {
    private double temperature;

    public Car1(double temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow() {
            if (temperature > 40) {
                System.out.println(temperature + "度,吹冷气");
            }else if (temperature < 0) {
                System.out.println(temperature + "度,吹暖气");
            }else {
                System.out.println(temperature + "度,关闭空调");
            }
        }
    }

    public Air getAir() {
        return new Air();
    }
}