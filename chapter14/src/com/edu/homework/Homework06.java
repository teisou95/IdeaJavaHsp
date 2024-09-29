package com.edu.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Vector;

public class Homework06 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Person1 p1 = new Person1(1001, "AA");
        Person1 p2 = new Person1(1002, "BB");
        System.out.println("p1.hashCode() = " + p1.hashCode());

        hashSet.add(p1);
        hashSet.add(p2);
        p1.name = "jack"; // p1 属性改了,但是table 表中 结点的 hash没有重算,还在原来的位置
        System.out.println("p1.hashCode() = " + p1.hashCode());
        System.out.println(hashSet);
        boolean contains = hashSet.contains(p1); // // 按新的属性计算hash 寻找索引,没找到p1
        System.out.println(contains); // 返回 不包含
        boolean remove = hashSet.remove(p1); // 按新的属性计算hash 寻找索引,没找到p1
        System.out.println(remove); // 移除失败
        System.out.println(hashSet);

        hashSet.add(new Person1(1001,"jack")); // 能放进去,因为原p1结点hash保持旧的hash
        System.out.println(hashSet);

        hashSet.add(new Person1(1001,"AA")); // 放进去了,因为和p1 hash相同,但equals false
        System.out.println(hashSet);


    }
}
class Person1 {
    public int id;
    public String name;

    public Person1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 如果不重写 hashCode(),修改属性不会导致 hashCode变化

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person1 person1 = (Person1) o;
        return id == person1.id &&
                Objects.equals(name, person1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

