package com.edu.homework;

import java.util.*;

@SuppressWarnings({"all"})
public class Homework03 {
    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);

        Map jack = new Map("jack", (int) hashMap.get("jack"));
        Map tom = new Map("tom", (int) hashMap.get("tom"));
        Map smith = new Map("smith", (int) hashMap.get("smith"));

        hashMap.put("jack",2600);
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            hashMap.replace(key,(Integer)hashMap.get(key) + 100);
//            hashMap.put(key,(Integer)hashMap.get(key) + 100);
        }


        Set set = hashMap.entrySet();
        iterator = set.iterator();
        while (iterator.hasNext()) {
            java.util.Map.Entry entry =  (java.util.Map.Entry)iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        Collection values = hashMap.values();
        for (Object o :values) {
//            System.out.println(o.getClass());
            System.out.println(o);
        }


    }
}

class Map {
    private String name;
    private int salary;

    public Map(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}