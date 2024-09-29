package com.edu.list_;

import java.util.ArrayList;
import java.util.Iterator;

public class ListExercise {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 12; i++) {
            list.add("hello" + i);
        }
        System.out.println("list = " + list);
        list.add(1,"哈哈");
        System.out.println("list = " + list);
        Object obj5 = list.get(4);
        System.out.println("obj5 = " + obj5);
        list.remove(5);
        System.out.println("list = " + list);
        list.set(6,"狼");
        System.out.println("list = " + list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
