package com.edu.exception;

/**
 * 数组索引越界异常
 */
public class ArrayIndexOutOfBoundsException_ {
    public static void main(String[] args) {
        int[] array = {1,2,4,6};
        try {
            for (int i = 0; i <= array.length; i++) {
                System.out.println(array[i]);
            }
        } catch (Exception e) {
            System.out.println(e); // java.lang.ArrayIndexOutOfBoundsException: 4
        }
    }
}
