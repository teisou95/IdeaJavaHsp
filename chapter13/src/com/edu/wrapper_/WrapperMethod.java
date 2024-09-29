package com.edu.wrapper_;

public class WrapperMethod {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE); // 最小值
        System.out.println(Integer.MAX_VALUE); // 最大值

        System.out.println(Character.isDigit('a')); // 判断是否数字
        System.out.println(Character.isLetter('a')); // 判断是否字母
        System.out.println(Character.isUpperCase('a')); // 判断大写
        System.out.println(Character.isLowerCase('a')); // 判断小写
        System.out.println(Character.toUpperCase('a')); // 转大写
        System.out.println(Character.toLowerCase('a')); // 转小写
    }
}
