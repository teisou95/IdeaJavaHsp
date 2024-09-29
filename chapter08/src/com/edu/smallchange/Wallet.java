package com.edu.smallchange;

/**
 * 钱包
 */
public class Wallet {
    private double balance; // 钱包余额
    private Function function = new Function();

    // 钱包初始化,最初余额定义
    public Wallet(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public Function getFunction() {
        return function;
    }

    // 收益入账方法
    public void income(double amount) {
        // 数据校验
//        if (amount > 0) {
//            System.out.println("收益入账了" + amount + "元");
//            balance += amount; // 增加余额
//            function.getDetail(amount, balance); // 添加至账单
//        } else {
//            System.out.println("入账金额有误,请重新选择");
//        }

        // 设置不正确的条件
        if (amount <= 0) {
            System.out.println("入账金额有误,请重新选择");
            return;
        }
        System.out.println("收益入账了" + amount + "元");
        balance += amount; // 增加余额
        function.getDetail(amount, balance); // 添加至账单
    }

    // 消费方法
    public void consume(String name, double amount) {
        // 数据校验
//        if (amount <= balance) {
//            System.out.println("在" + name + "商户消费了" + amount + "元");
//            balance -= amount; // 扣减余额
//            function.getDetail(name, amount, balance); // 添加至账单
//        } else {
//            System.out.println("消费金额超出余额,请重新选择");
//        }

        if (amount > balance || amount <= 0) {
            System.out.println("消费金额有误,请重新选择");
            return;
        }
        System.out.println("在" + name + "商户消费了" + amount + "元");
        balance -= amount; // 扣减余额
        function.getDetail(name, amount, balance); // 添加至账单
    }


}
