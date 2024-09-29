package com.edu.smallchange;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 * 子项功能
 */
public class Function {
    //    private String[] details = new String[100]; // 账单明细
    private String details = ""; // 采用字符串拼接替代数组方案,可以不受数组长度限制
    private int count = 0; // 计数账单条数
    private Scanner scanner = new Scanner(System.in);

    // 显示菜单方法
    public void printMenu() {
        // 显示菜单
        System.out.println("--------------------零钱通菜单--------------------");
        System.out.println("       1 零钱通明细");
        System.out.println("       2 收益入账");
        System.out.println("       3 消费");
        System.out.println("       4 退出");

        // 提示选择输入
        System.out.println("请选择(1-4):");
    }


    // 消费记录入账
    public void getDetail(String name, double amount, double balance) {
//        details[count] = name + "\t-" + amount + "\t" + getTime() + "\t余额:" + balance;
        details += name + "\t-" + amount + "\t" + getTime() + "\t余额:" + balance + "\n";
        count++;
    }

    // 收益记录入账
    public void getDetail(double amount, double balance) {
//        details[count] = "收益入账" + "\t+" + amount + "\t" + getTime() + "\t余额:" + balance;
        details += "收益入账" + "\t+" + amount + "\t" + getTime() + "\t余额:" + balance + "\n";
        count++;
    }


    // 打印账单明细
    public void printDetail(Wallet wallet) {
        System.out.println("--------------------零钱通明细--------------------");
        if (count == 0) {
            System.out.println("暂无账单记录,当前余额:" + wallet.getBalance() + "\n");
        } else {
//            for (int i = 0; i < count; i++) {
//                System.out.println(details[i]);
//            }
            System.out.println(details);
        }
//        System.out.println();
    }

    // 优化代码,确认是否退出
    public String isExit() {
        // 递归实现
//        System.out.println("你确定要退出吗?(y/n):");
//        String yesOrNo = scanner.next();
//        if ("y".equals(yesOrNo)) {
//            System.out.println("退出了零钱通项目");
//            return "4";
//        } else if ("n".equals(yesOrNo)) {
//            System.out.println("返回上级菜单,请重新选择");
//            return "0";
//        } else {
//            System.out.println("输入有误,请重新输入");
//            return isExit();
//        }

        // 循环实现
        String yesOrNo = "";
        do {
            System.out.println("你确定要退出吗?(y/n):");
            yesOrNo = scanner.next();
        } while (!"y".equals(yesOrNo) && !"n".equals(yesOrNo));

        if ("y".equals(yesOrNo)) {
            System.out.println("你退出了零钱通");
            return "4";
        } else {
            return "-1";
        }
    }

    // 获取时间方法
    public String getTime() {
//        // 获取当前日期时间
//        LocalDateTime now = LocalDateTime.now();
//
//
//        // 定义日期时间格式化器
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        // 格式化日期时间
//        String formattedNow = now.format(formatter);
//
//        // 打印当前日期时间
//        return formattedNow;

        Date date = new Date(); // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 用于日期格式化
        return sdf.format(date); // 返回日期
    }


}
