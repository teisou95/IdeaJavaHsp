package com.edu.homework;

public class Homework02 {
    public static void main(String[] args) {
        try {
//            args = new String[5]; // 空指针异常
            if (args[4].equals("john")) { // 数组越界异常
                System.out.println("aa");
            } else {
                System.out.println("bb");
            }
            Object o = args[2];
            Integer i = (Integer)o; // 类型转换异常
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (ClassCastException e) {
            System.out.println(e);
        }

    }
}
