package com.edu.string_;



/**
 * String 实现了 串行化 和 可比较 两个重要接口
 * Serializable 串行化接口:可以网络传输
 * Comparable 可比较接口:compareTo 方法
 * String 是 final 类
 * 有属性 final char value[]; 用于存放字符串内容,本质是字符数组
 * value[] 是 final 类型,赋值后不能更改(地址不能修改)
 * 一个字符占两个字节
 * 构造器很多
 */
public class String_ {
    public static void main(String[] args) {
        String name = "jack";
        System.out.println("name = " + name);
        final char[] value = {'a','1','p'};
        value[1] = 'H';

        String s = new String();
        System.out.println("s = " + s);

        char[] chars = {'1','a','&'};
        String s1 = new String(chars);
        System.out.println("s1 = " + s1);

        String s2 = new String(chars, 1, 2);
        System.out.println("s2 = " + s2);

        byte[] bytes = {1,0,5};
        String s3 = new String(bytes);
        System.out.println("s3 = " + s3);


    }
}
