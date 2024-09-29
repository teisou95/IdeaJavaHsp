package com.edu.homework.t08;

public class SavingAccount extends BankAccount {
    private double interestRate; // 存款月利率
    private int count = 3; // 每月免手续费存取款次数

    public SavingAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
        System.out.println("设定月利率" + interestRate);
    }


    public void earnMonthlyInterest() { // 每月计算利息
//        setBalance(getBalance() * (1 + interestRate)); // 存款本息和
        System.out.print("已计息一次,存取款次数重置");
        super.deposit(interestRate * getBalance()); // 利息存入账户
        count = 3; // 重置交易次数

    }

    @Override
    public void deposit(double amount) {
        System.out.print("本月第" + (4 - count) + "次存取款:");
        if (count <= 0 && getBalance() + amount < 1) {
            System.out.println("余额不足,存款失败");
            return;
        }
        System.out.print("存款" + amount);
        if (count > 0) {
            super.deposit(amount); // 每月前三次存取款免手续费
        } else {
            super.deposit(amount - 1);
        }
        count--;
    }

    @Override
    public void withdraw(double amount) {
        System.out.print("本月第" + (4 - count) + "次存取款:");
        if ((count <= 0 && getBalance() < amount + 1) || (count > 0 && getBalance() < amount)) {
            System.out.println("余额不足,取款失败");
            return;
        }
        System.out.print("取款" + amount);
        if (count > 0) {
            super.withdraw(amount); // 每月前三次存取款免手续费
        } else {
            super.withdraw(amount + 1);
        }
        count--;
    }
}
