package com.edu.customgeneric;

public class Exercise02 {
    public static void main(String[] args) {
        Apple<String, Integer, Double> apple = new Apple<>();
        apple.fly(10);
        apple.fly(new Inu());
    }
}
class Apple<T,R,M> {
    public <F> void fly(F e) {
        System.out.println("e.getClass().getSimpleName() = " + e.getClass().getSimpleName());
    }
    public void run(M m) {}
}

class Inu {}