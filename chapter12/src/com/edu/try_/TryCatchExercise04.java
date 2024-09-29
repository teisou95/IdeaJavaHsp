package com.edu.try_;

import java.util.Scanner;

public class TryCatchExercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            try {
                System.out.println("请输入一个整数");
                num = Integer.parseInt(scanner.next()); // 可能抛出异常
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入错误");
            }
        }
        System.out.println(num);
    }
}
