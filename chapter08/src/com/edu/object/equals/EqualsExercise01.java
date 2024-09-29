package com.edu.object.equals;

/**
 * 0321
 * 重写 equals 方法,判断两个 Person 的对象的内容是否相等
 * 如果两个对象的各个属性值都一样,则返回true,否则false
 */
public class EqualsExercise01 {
    public static void main(String[] args) {
        Person king = new Person("king", 25, '男');
        Person jack = new Person("jack", 30, '男');
        Person king1 = new Person("king", 25, '男');
        System.out.println(king == king1); // F
        System.out.println(king.equals(king1)); // T
        System.out.println(king.equals(jack)); // F
        System.out.println(king.equals(null)); // F
    }
}

