package com.edu.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionExercise {
    public static void main(String[] args) {
        List dogs = new ArrayList();
        dogs.add(new Dog("haha", 3));
        dogs.add(new Dog("kaka", 5));
        dogs.add(new Dog("papa", 7));

        System.out.println("迭代器遍历");
        Iterator iterator = dogs.iterator();
        while (iterator.hasNext()) {
            Object dog = iterator.next();
            System.out.println("dog = " + dog);
        }

        System.out.println("增强for 遍历");
        for (Object dog : dogs) {
            System.out.println("dog = " + dog);
        }

    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
