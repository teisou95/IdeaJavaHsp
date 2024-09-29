package com.edu.exception;

/**
 * 异常捕获
 * try-catch 异常处理机制
 * 保证程序的健壮性
 * 算数异常
 */
public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        try {
            int res = num1 / num2; // 运行时异常 编译器检测不出
        }catch (ArithmeticException e) {
            System.out.println("捕获到异常信息如下:");
            System.out.println(e);
//            System.out.println(e.getMessage());
        }

        // 快捷键 CTRL + ALT + T
//        try {
//            int res = num1 / num2;
//        } catch (Exception e) {
//            e.printStackTrace(); // 即使出现错误,程序可以继续执行
//        }
// Exception in thread "main" java.lang.ArithmeticException: / by zero
        System.out.println("程序继续运行");
    }
}

