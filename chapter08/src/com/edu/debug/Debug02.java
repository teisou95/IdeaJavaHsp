package com.edu.debug;

public class Debug02 {
    public static void main(String[] args) {
        // debug 异常演示
        int[] arr = {1, 2, 3, 4};
        for (int i = 0; i < arr.length + 1; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("退出循环");
    }
}
