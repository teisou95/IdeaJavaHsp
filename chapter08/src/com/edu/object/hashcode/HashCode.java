package com.edu.object.hashcode;

/**
 *hashCode()方法,提高具有哈希结构的容器的效率
 * 针对不同的对象返回不同的整数
 * 同一个对象返回同一个整数
 * 哈希值主要根据地址得来,但不完全等同于地址
 */
public class HashCode {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        System.out.println("a1.hashCode() = " + a1.hashCode());
        System.out.println("a2.hashCode() = " + a2.hashCode());

        A a3 = a1;
        System.out.println("a3.hashCode() = " + a3.hashCode());
    }
}
