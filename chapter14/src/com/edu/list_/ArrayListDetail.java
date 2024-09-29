package com.edu.list_;

import java.util.ArrayList;

/**
 * ArrayList 可存放所有的元素 甚至是 null 并且可以多个null
 * 底层是数组实现数据存储
 * 基本等同于 Vector 但是 ArrayList 线程不安全
 */
public class ArrayListDetail {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("das");
        arrayList.add(null);
        arrayList.add(66);
        arrayList.add(null);
        System.out.println(arrayList);
    }
}
