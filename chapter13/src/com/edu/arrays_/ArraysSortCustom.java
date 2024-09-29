package com.edu.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 自定义排序接口
 */
public class ArraysSortCustom {
    public static void main(String[] args) {
        int[] arr = {1, -1, 8, 0, 20};
//        bubble01(arr);
        bubble02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int j1 = (Integer) o1;
                int j2 = (Integer) o2;
                return j2 - j1;
            }
        });
        System.out.println(Arrays.toString(arr));

    }

    // 使用冒泡完成排序 从小到大
    public static void bubble01(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubble02(int[] arr, Comparator c) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (c.compare(arr[j],arr[j + 1]) > 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
