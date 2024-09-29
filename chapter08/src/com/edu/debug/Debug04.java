package com.edu.debug;

import java.util.Arrays;

/**
 * F9执行到下一个断点
 * 系统源码也可以下断点
 */
public class Debug04 {
    public static void main(String[] args) {
        int[] arr = {1, -1, 10, -20, 100};
        // debug F7 跳入方法体内

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("hello100");
        System.out.println("hello200");
        System.out.println("hello300");
        System.out.println("hello400");
        System.out.println("hello500");
        System.out.println("hello600");
        System.out.println("hello700");
    }

}
