package com.edu.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 完成各项功能
 */
public class SmallChangeSysOOP {
    private double balance; // 余额
    private String details = ""; // 账单明细
    private double money; // 入账金额
    private boolean loop = true; // 循环判定
    private final Scanner scanner = new Scanner(System.in);

    // 显示菜单
    public void printMenu() {
        System.out.println("--------------------OOP零钱通菜单--------------------");
        System.out.println("       1 零钱通明细");
        System.out.println("       2 收益入账");
        System.out.println("       3 消费");
        System.out.println("       4 退出");

        // 提示选择输入
        System.out.println("请选择(1-4):");
    }

    // 根据用户选择进入菜单
    public void mainMenu() {
        while (loop) {
            printMenu(); // 显示菜单
            String key = scanner.next(); // 接收用户输入

            //根据选择显示对应项
            switch (key) {
                case "1": // 显示明细
                    printDetail();
                    break;
                case "2": // 收益入账
                    income();
                    break;
                case "3": // 消费入账
                    pay();
                    break;
                case "4": // 退出
                    exit();
                    break;
                default:
                    System.out.println("输入错误,请重新输入");
            }
        }
    }

    // 打印账单明细
    public void printDetail() {
        System.out.println("--------------------零钱通明细--------------------");
        if (details.length() == 0) {
            System.out.println("暂无账单记录,当前余额:" + balance + "\n");
            return;
        }
        System.out.println(details);
    }

    // 收益入账
    public void income() {
        System.out.println("请输入收益金额");
        money = scanner.nextDouble();
        // 数据校验
        if (money <= 0) {
            System.out.println("收益金额必须大于0");
            return;
        }
        System.out.println("收益入账了" + money + "元");
        balance += money; // 增加余额
        details += "收益入账" + "\t+" + money + "\t" + getTime() + "\t余额:" + balance + "\n"; // 添加至账单
    }

    // 消费入账
    public void pay() {
        System.out.println("请输入消费商户名");
        String name = scanner.next();
        System.out.println("请输入消费金额");
        money = scanner.nextDouble();

        // 数据校验
        if (money > balance || money <= 0) {
            System.out.println("消费金额必须在0~" + balance + "之间");
            return;
        }
        System.out.println("在" + name + "商户消费了" + money + "元");
        balance -= money; // 扣减余额
        details += name + "\t-" + money + "\t" + getTime() + "\t余额:" + balance + "\n"; // 添加至账单
    }

    // 获取时间
    public String getTime() {
        Date date = new Date(); // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 用于日期格式化
        return sdf.format(date); // 返回日期
    }

    // 确认退出
    public void exit() {
        String choice;
        do {
            System.out.println("你确定要退出吗?(y/n):");
            choice = scanner.next();
        } while (!"y".equals(choice) && !"n".equals(choice));
        if ("y".equals(choice)) {
            System.out.println("你退出了零钱通");
            loop = false;
        }
    }
}
