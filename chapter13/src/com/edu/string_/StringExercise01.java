package com.edu.string_;

public class StringExercise01 {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        String c = "abc";
        System.out.println(a.equals(b)); // t
        System.out.println(a == b); // f
        // intern 方法 返回 字符串在常量池中内容相同的 常量池 的地址
        System.out.println(a == b.intern()); // t
        System.out.println(b == b.intern()); // f

        System.out.println("===========");
        System.out.println(a == c); // t
    }
}
