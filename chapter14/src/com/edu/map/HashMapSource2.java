package com.edu.map;

import java.util.*;
@SuppressWarnings({"all"})
public class HashMapSource2 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 9; i++) {
            hashMap.put(new A(i), "hello");
        }
        System.out.println(hashMap);
        for (int i = 0; i < 50; i++) {
            hashMap.put(i,"hello");
        }
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());

        }
    }
}

class A {
    private int num;

    public A(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return num == a.num;
    }

    @Override
    public int hashCode() {
        return 100; // 让每个A对象的hashCode都一样
    }

    @Override
    public String toString() {
        return "\nA{" +
                "num=" + num +
                '}';
    }
}
