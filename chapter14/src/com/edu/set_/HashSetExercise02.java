package com.edu.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

@SuppressWarnings({"all"})
public class HashSetExercise02 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee02("mary",12000,new MyDate(1987,5,5)));
        hashSet.add(new Employee02("jack",16000,new MyDate(1972,3,19)));
        hashSet.add(new Employee02("tom",25000,new MyDate(1966,9,10)));
        hashSet.add(new Employee02("jack",4000,new MyDate(1972,3,19)));
//        System.out.println(hashSet);
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
class Employee02 {
    private String name;
    private double salary;
    private MyDate birthday;

    public Employee02(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee02 that = (Employee02) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee02{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}
class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year &&
                month == myDate.month &&
                day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return year + "年" + month + "月" + day + "日";
    }
}