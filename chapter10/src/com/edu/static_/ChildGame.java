package com.edu.static_;

import java.util.Scanner;

public class ChildGame {
    public static void main(String[] args) {
        int count = 0;
        count += addChild();
        System.out.println("最终有" + count + "人");

    }

    public static int addChild() {
        int sum = 0;
        while (true) {
            System.out.println("几人加入游戏?");
            Scanner scanner = new Scanner(System.in);
            int childNewNum = scanner.nextInt();
            if (childNewNum == 0) {
                break;
            }
            sum += childNewNum;
        }
        return sum;
    }
}

