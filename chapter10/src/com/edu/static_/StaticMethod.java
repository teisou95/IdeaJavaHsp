package com.edu.static_;

import java.util.Scanner;

/**
 * 静的メソッド
 * 呼び出し: クラス名 クラスのメソッド名。
 * static 方法 只能访问 static 成员
 */
public class StaticMethod {
    public static void main(String[] args) {
        Student.payFee(30);
        Student king = new Student("king",100);
        Student tom = new Student("tom", 100);
        Student.showFee();

        System.out.println(MyTools.calSum(1,5));

    }
}

class Student {
    private String name;
    private static double fee = 0; // 静的変数　学生授業料

    public Student() {
    }

    public Student(String name, double fee) {
        this.name = name;
        Student.fee += fee;
    }

    public static void payFee(double fee) {
        Student.fee += fee; // 累計授業料
    }

    public static void showFee() {
        System.out.println("累計授業料" + Student.fee);
    }
}

class MyTools {
    public static double calSum(double n1,double n2) {
        return n1 + n2;
    }
}