package com.edu.homework.t01;

public class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Person() {
    }

    // 冒泡排序 年龄从大到小
    public void sortArrAge(Person[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].age < people[j + 1].age) {
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
        System.out.println("完成了年龄从大到小排序");
    }

    // 冒泡排序 名字长度从大到小
    public void sortArrNameLength(Person[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].name.length() < people[j + 1].name.length()) {
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
        System.out.println("完成了名字长度从大到小排序");
    }

    // 打印数组
    public void printArr(Person[] people) {
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", age=" + age +", job='" + job + '\'';
    }
}
