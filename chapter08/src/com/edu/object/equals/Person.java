package com.edu.object.equals;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /**
     * 重写 equals方法
     */
    public boolean equals(Object obj) {
        // 判断是否是同一类对象
//        super.equals(obj);
        if (this == obj) {
            return true;
        }
        // 类型判断
        if (obj instanceof Person) { // 是 Person 才比较
            // 向下转型,属性比较
//            if (name.equals(((Person) obj).name) &&
//                    age == ((Person) obj).age &&
//                    gender == ((Person) obj).gender) {
//                return true;
            return name.equals(((Person) obj).name) &&
                    age == ((Person) obj).age &&
                    gender == ((Person) obj).gender;
        }
        return false;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return age == person.age &&
//                gender == person.gender &&
//                Objects.equals(name, person.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age, gender);
//    }
}
