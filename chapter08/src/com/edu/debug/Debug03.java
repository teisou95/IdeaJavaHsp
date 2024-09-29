package com.edu.debug;

import java.util.Arrays;

/**
 *
 * debug 进入方法体
 */
public class Debug03 {
    public static void main(String[] args) {
        int[] arr = {1,-1,10,-20,100};
        // debug F7 跳入方法体内

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
