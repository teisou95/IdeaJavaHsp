package com.edu.generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 泛型
 */
//@SuppressWarnings({"all"})
public class generic_ {
    public static void main(String[] args) {
        // ArrayList<Dog> 存放到 ArrayList 集合的类型是 Dog 类型
        // public class ArrayList<E> E代表泛型
        ArrayList<Dog> dogs = new ArrayList<Dog>(); // 使用泛型后 遍历不需要转型了
        dogs.add(new Dog("jack", 10));
        dogs.add(new Dog("mary", 3));
        dogs.add(new Dog("king", 5));
//        list.add(1); // 非 Dog 对象 加不进去了,编译器会进行检测类型,限制集合的元素类型
        Iterator<Dog> iterator = dogs.iterator(); // 迭代器自动添加对应泛型
        while (iterator.hasNext()) {
            Dog dog = iterator.next(); // 不需要手动类型转换了
            System.out.println(dog.getName() + " " + dog.getAge());
        }
//
        for (Dog dog : dogs) {
            System.out.println(dog.getName() + " " + dog.getAge());
        }


    }
}

class Dog {
    private String name;
    private int age;


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

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
