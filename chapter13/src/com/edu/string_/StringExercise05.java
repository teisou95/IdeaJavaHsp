package com.edu.string_;

public class StringExercise05 {
    public static void main(String[] args) {
        String a = "hello" + "abc";
        // 创建了1个对象
        // 底层直接生成 helloabc 常量
        // 优化等价于 String a = "helloabc";

        String s1 = "hi";
        String s2 = "aa";
        // 创建一个 StringBuilder
        // StringBuilder append("hi")
        // StringBuilder append("aa")
        // StringBuilder toString() 返回new 对象
        String s3 = s1 + s2;
        // 创建了3个对象
        // s3 指向堆,底层是 new 出的String 对象
        String s4 = "hi" + "aa";
        System.out.println(s3 == s4); // false

        String s5 = "hiaa";
        System.out.println(s4 == s5); // true
    }
}
