package com.edu.generic;

import java.util.ArrayList;
import java.util.Iterator;

public class Generic03 {
    public static void main(String[] args) {
        Person<Integer,String> jack = new Person<>("jack"); // E = String
        Person<Integer,String> king = new Person<>("king");
        Person<Integer,Integer> intPerson = new Person<>(26); // E = Integer
        jack.printNameClass();
        intPerson.printNameClass();
        king.setNum(12);
        ArrayList<String> strings = new ArrayList<>();
        Iterator<String> iterator = strings.iterator();

    }
}

// 类创建时指定泛型
class Person<K,V> {
    // 作属性类型
    private V name;
    private K num;

    // 作参数类型
    public Person(V name) {
        this.name = name;
    }

    // 作返回类型
    public V getName() {
        return name;
    }

    public K getNum() {
        return num;
    }

    public void setNum(K num) {
        this.num = num;
    }

    public void printNameClass() {
        System.out.println(name.getClass());
    }
}