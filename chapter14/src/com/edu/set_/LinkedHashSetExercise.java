package com.edu.set_;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class LinkedHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("奥拓", 0.1));
        linkedHashSet.add(new Car("奥迪", 30));
        linkedHashSet.add(new Car("法拉利", 1000));
        linkedHashSet.add(new Car("奥迪", 30));
        linkedHashSet.add(new Car("保时捷", 7000));
        linkedHashSet.add(new Car("奥迪", 300));
        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
