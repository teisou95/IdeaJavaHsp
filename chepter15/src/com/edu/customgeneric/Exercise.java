package com.edu.customgeneric;

public class Exercise {
    public static void main(String[] args) {
        Dog<Double, String, Integer> king = new Dog<>("king");
        king.setT(10.9);
//        king.setT("yy");
        System.out.println("king = " + king);

        Dog wang = new Dog("wang");
        wang.setT("yy");
        System.out.println("wang = " + wang);
    }
}

class Dog<T,M,R> {
    private String name;
    private T t;
    private M m;
    private R r;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", t=" + t +
                ", m=" + m +
                ", r=" + r +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public Dog(String name) {
        this.name = name;
    }
}
