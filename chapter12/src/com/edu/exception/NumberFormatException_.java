package com.edu.exception;

/**
 * 数字格式不正确异常
 */
public class NumberFormatException_ {
    public static void main(String[] args) {
        String name = "dhdajd";
        // 将 String 转为 int
        try {
            int num = Integer.parseInt(na me);
            System.out.println("num = " + num);
        } catch (NumberFormatException e) {
            System.out.println(e); // java.lang.NumberFormatException: For input string: "dhdajd"
        }
    }
}
