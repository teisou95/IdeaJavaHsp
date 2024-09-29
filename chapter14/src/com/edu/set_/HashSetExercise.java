package com.edu.set_;

import java.util.HashSet;
import java.util.Objects;
@SuppressWarnings({"all"})
public class HashSetExercise {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Employee jack = new Employee("jack", 25);
        Employee mary = new Employee("mary", 21);
        Employee king = new Employee("king", 40);
        Employee wang = new Employee("king", 40);
        hashSet.add(jack);
        hashSet.add(mary);
        hashSet.add(king);
        hashSet.add(wang); // hashCode 相同且 wang.equals(king) == true ,加不进去
        System.out.println(hashSet);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}