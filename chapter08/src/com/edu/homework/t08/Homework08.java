package com.edu.homework.t08;

public class Homework08 {
    public static void main(String[] args) {
        CheckingAccount king = new CheckingAccount(2000);
        king.deposit(100);
        king.withdraw(300);
        System.out.println("king.getBalance() = " + king.getBalance());

        System.out.println("============================");
        SavingAccount wang = new SavingAccount(200, 0.01);
        wang.deposit(100);
        wang.deposit(105);
        wang.withdraw(36);
        wang.deposit(200);
        wang.withdraw(150);

        wang.earnMonthlyInterest(); // 月末计息
        wang.withdraw(20);;
        wang.deposit(100);
        System.out.println("wang.getBalance() = " + wang.getBalance());
    }
}
