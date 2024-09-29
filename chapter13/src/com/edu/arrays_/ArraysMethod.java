package com.edu.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysMethod {
    public static void main(String[] args) {
        Integer[] integers = {1,20,90};
//        for (int i = 0; i < integers.length; i++) {
//            System.out.println(integers[i]);
//        }
        String s = Arrays.toString(integers);
        System.out.println(s);

        // 默认排序 从小到大
        integers = new Integer[]{1, -1, 7, 0, 89};
//        Arrays.sort(integers);
//        System.out.println(Arrays.toString(integers));

        // 定制排序
        // 传入一个实现了 Comparator 接口的 匿名内部类
        // 自定义排序规则
        Arrays.sort(integers, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1; // 返回数的正负 影响排序规则
            }
        });
        System.out.println(Arrays.toString(integers));
    }
}
