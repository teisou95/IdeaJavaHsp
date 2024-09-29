package com.edu.homework;

import java.util.Scanner;

/**
 * 0495
 */
public class Homework02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        while (true) {
            try {
                if (account.getName() == null) {
                    System.out.println("请输入用户名");
                    account.setName(scanner.next());
                }

                if (account.getPassword() == null) {
                    System.out.println("请输入密码");
                    account.setPassword(scanner.next());
                }

                if (account.getMailAddress() == null) {
                    System.out.println("请输入邮箱地址");
                    account.setMailAddress(scanner.next());
                }

                System.out.println("成功建立账户如下:" + account);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

class Account {
    private String name; // 用户名 长度2 3 4
    private String password; // 密码 长度6 全数字
    private String mailAddress; // 邮箱 包含 @ .

    public Account() {
    }

    public Account(String name, String password, String mailAddress) {
        setName(name);
        setPassword(password);
        setMailAddress(mailAddress);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!(name != null &&
                name.length() >= 2 &&
                name.length() <= 4)) {
            throw new RuntimeException("用户名必须是2~4个字符");
        }
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!(password != null &&
                password.length() == 6)) {
            throw new RuntimeException("密码长度必须为6");
        }
        if (!(isDigital(password))) {
            throw new RuntimeException("密码必须全部为数字");
        }
        this.password = password;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        if (mailAddress == null) {
            throw new NullPointerException("邮箱不能为空");
        }
        int index = mailAddress.indexOf("@");
        int index2 = mailAddress.lastIndexOf("@");
        int index1 = mailAddress.indexOf(".");
        if (!(index != -1 && index1 != -1 // 必须有 @ 和 .
                && index != 0 && index1 != (mailAddress.length() - 1) // 不能是首尾位置
                && index == index2 && index < index1)) { // 只能有一个 @ 且在 . 前面
            throw new RuntimeException("邮箱格式不正确");
        }
        this.mailAddress = mailAddress;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                '}';
    }

    public boolean isDigital(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
//            if (!(chars[i] >= "0" && chars[i] <= "9")) {
//                return false;
//            }
            if (!(Character.isDigit(chars[i]))) {
                return false;
            }
        }
        return true;
    }
}