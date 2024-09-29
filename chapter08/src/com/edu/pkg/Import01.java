package com.edu.pkg;

import java.util.Arrays;

public class Import01 {
    /*
        导入包
        语法:import 包;
        目的:使用该包下面的类
        需要使用哪个类,就导入哪个类即可
        import java.util.Scanner; // 只是引入一个类
        import java.util.*; // 表示引入整个包下所有类
     */
    public static void main(String[] args) {
        // 使用系统提供的类 Arrays 完成数组排序
        int[] arr = {-1, 20, 2, 13, 3};
        // 对数组进行排序
        // 传统方法,自己编写排序法
        // 系统提供相关的类,可以方便完成排序 Arrays
        Arrays.sort(arr); // 从小到大完成了排序
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
