package com.edu.homework;

public class Homework04 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator() {
            @Override // 匿名内部类重写接口方法
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        };
        CellPhone cellPhone = new CellPhone();

        cellPhone.testWork(calculator, 25, 30);

        cellPhone.testWork(new Calculator() {
            @Override
            public double work(double n1, double n2) {
                return n1 * n1;
            }
        },20,5.2);

    }
}

interface Calculator { // 计算器接口
    double work(double n1, double n2); // 运算方法
}

class CellPhone {
    public void testWork(Calculator calculator, double n1, double n2) {
        double result = calculator.work(n1, n2);
        System.out.println("计算结果是 " + result);
    }
}