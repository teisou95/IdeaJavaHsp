package com.edu.generic;

import java.util.*;

/**
 * 0557
 * 泛型
 */
public class GenericExercise {
    public static void main(String[] args) {
        Student jack = new Student("jack",17);
        Student mary = new Student("mary",20);
        Student king = new Student("king",15 );

        HashMap<String, Student> studentHashMap = new HashMap<>();
        studentHashMap.put("jack",jack);
        studentHashMap.put("mary",mary);
        studentHashMap.put("king",king);

        System.out.println("================entrySet 遍历==============");
        Set<Map.Entry<String, Student>> entries = studentHashMap.entrySet();
        for (Map.Entry<String ,Student> entry :entries) {
            System.out.println("value = " + entry.getValue());
        }

        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> entry = iterator.next();
            System.out.println("entry.getValue() = " + entry.getValue());
        }

        System.out.println("================keySet 遍历==============");
        Set<String> keySet = studentHashMap.keySet();
        for (String key :keySet) {
            System.out.println("studentHashMap.get(key) = " + studentHashMap.get(key));
        }

        Iterator<String> iterator1 = keySet.iterator();
        while (iterator1.hasNext()) {
            String next = iterator1.next();
            System.out.println("studentHashMap.get(next) = " + studentHashMap.get(next));
        }

        System.out.println("================values 遍历==============");
        Collection<Student> values = studentHashMap.values();
        for (int i = 0; i < values.size(); i++) {
            System.out.println("values = " + values.toArray()[i]);
        }

        for (Student student :values) {
            System.out.println("student = " + student);
        }

        Iterator<Student> iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Student student = iterator2.next();
            System.out.println("student = " + student);
        }

        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(king);
        hashSet.add(mary);
        hashSet.add(jack);
        System.out.println("================hashSet 遍历==============");
        Iterator<Student> iterator3 = hashSet.iterator();
        while (iterator3.hasNext()) {
            Student student = iterator3.next();
            System.out.println("student = " + student);
        }

    }
}

class Student {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}