package com.edu.homework.t01;

public class Homework01 {
    public static void main(String[] args) {
        Person person = new Person();
        Person[] people = new Person[3];
        people[0] = new Person("king", 25, "aaa");
        people[1] = new Person("jack", 30, "bbb");
        people[2] = new Person("huahua", 19,"ccc");

        // 排序
        person.sortArrAge(people);
        // 打印
        person.printArr(people);

        person.sortArrNameLength(people);
        person.printArr(people);

    }
}
