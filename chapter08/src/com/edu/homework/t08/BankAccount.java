package com.edu.homework.t08;

public class BankAccount {
    private double balance; // 余额

    public BankAccount(double initialBalance) { // 初始余额
        this.balance = initialBalance;
        System.out.println("初始余额" + balance);
    }

    public void deposit(double amount) { // 存款
        balance += amount;
        System.out.println("\t当前余额" + balance);
    }

    public void withdraw(double amount) { // 取款
        balance -= amount;
        System.out.println("\t当前余额" + balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
