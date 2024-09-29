package com.edu.homework;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings({"all"})
public class Homework02 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Car car1 = new Car("宝马", 40);
        Car car2 = new Car("宾利", 500);
        list.add(car1);
        list.add(car2);
        list.add(car1);

        list.remove(car1);

        System.out.println("list.contains(car2) = " + list.contains(car2));;

        int size = list.size();
        System.out.println("size = " + size);

        System.out.println("list.isEmpty = " + list.isEmpty());

//        list.clear();

        list.addAll(1,list);

        ArrayList list1 = new ArrayList();
        list1.add(car1);
        list1.add(car2);
        System.out.println("list1 = " + list1);
        System.out.println("list.containsAll(list1) = " + list.containsAll(list1)); // 无关顺序

        System.out.println(list.containsAll(list1));

//        list.removeAll(list1); // 删除全部(包含重复)

        for (Object o :list) {
            System.out.println((Car)o);
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println("next = " + next);
        }


    }
}
class Car {
    private String name;
    private double price;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
