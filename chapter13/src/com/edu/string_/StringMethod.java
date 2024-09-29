package com.edu.string_;

public class StringMethod {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "HELLO";
        System.out.println(s1.equals(s2)); // f

        String name = "johN";
        System.out.println("john".equals(name)); // f
        System.out.println("john".equalsIgnoreCase(name)); // t

        System.out.println("mary".length()); // 4

        String s3 = "jdh@fhuds@cj";
        System.out.println(s3.indexOf('@')); // 3
        System.out.println(s3.indexOf('6')); // -1
        System.out.println(s3.lastIndexOf('@')); // 9
        System.out.println(s3.indexOf("fh")); // 4
        System.out.println(s3.indexOf("j",5)); // 11
        System.out.println(s3.lastIndexOf("ds")); // 7
        System.out.println(s3.lastIndexOf("j",2)); // 0

        String sName = "hello,张三";
        System.out.println(sName.substring(6)); // 张三
        System.out.println(sName.substring(6,7)); // 张 // index从6开始到7 (不包括7)

    }
}
