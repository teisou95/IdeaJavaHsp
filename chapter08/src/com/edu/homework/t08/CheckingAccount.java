package com.edu.homework.t08;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (getBalance() + amount < 1) {
            System.out.println("余额不足,存款失败");
            return;
        }
        System.out.print("存款" + amount);
        super.deposit(amount - 1); // 存款手续费
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() < amount + 1) {
            System.out.println("余额不足,取款失败");
            return;
        }
        System.out.print("取款" + amount);
        super.withdraw(amount + 1); // 取款手续费
    }
}
