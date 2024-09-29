package com.edu.debug;

public class Person {
    private String name = "king";
    private int age = 25;
    private double sal = 12500;

    public Person(String name, int age, double sal) {
        this.name = name;
        this.age = age;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sal=" + sal +
                '}';
    }
}
