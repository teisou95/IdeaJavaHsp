package com.edu.arrays_;

import java.util.Arrays;
import java.util.List;

/**
 * 0484
 * Arrays 方法
 */
public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1, 0, 5, 98, 75};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 二叉查找
        int index = Arrays.binarySearch(arr, 6); // -4
        //         return -(low + 1);  // key not found.
        System.out.println(index);

        // copyOf 数组元素复制 确定复制个数,超出置空
        Integer[] newArr = Arrays.copyOf(arr, arr.length + 1);
        System.out.println(Arrays.toString(newArr));

        // fill 数组填充,替换所有元素
        Arrays.fill(arr, 99);
        System.out.println(Arrays.toString(arr));

        // equals 比较数组内容
        arr = new Integer[]{1, 2, 5, 8};
        Integer[] arr2 = {1, 2, 5, 8};
        System.out.println(Arrays.equals(arr,arr2));

        // asLise 将一组值,转换为 list 集合
        List<Integer> integers = Arrays.asList(arr);
        System.out.println(integers.getClass()); //class java.util.Arrays$ArrayList 内部类
        System.out.println(integers);
    }
}
