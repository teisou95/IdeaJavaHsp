package com.edu.encap;

public class Account {
    private String name;
    private double balance;
    private String password;

    public Account() {
    }

    public Account(String name, double balance, String password) {
        this.setName(name);
        this.setBalance(balance);
        this.setPassword(password);
    }

    public void setName(String name) {
        if (name != null && name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            System.out.println("name必须为2~4为,默认:无名");
            this.name = "无名";
        }
    }

    public void setBalance(double balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("余额必须大于20,默认:100");
            this.balance = 100;
        }
    }

    public void setPassword(String password) {
        if (password != null & password.length() == 6) {
            this.password = password;
        } else {
            System.out.println("密码必须为6位,默认:123456");
            this.password = "123456";
        }
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public String info() {
        return "name = " + getName() + "\nbalance = " + getBalance() + "\npassword = " + getPassword();
    }
}
