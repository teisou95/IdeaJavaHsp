package com.edu.homework.t13;

public class Person {
    private String name;
    private char gender;
    private int age;

    public Person(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String play() {
        return name + "爱玩";
    }

    public void printInfo() {
        System.out.println("的信息:\n姓名:" + name + "\n年龄:" + age + "\n性别:" + gender);
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
}
