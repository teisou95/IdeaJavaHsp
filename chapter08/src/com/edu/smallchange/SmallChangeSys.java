package com.edu.smallchange;

import java.util.Scanner;

/**
 *
 * 零钱通项目,可以完成收益入账/消费/查看明细/退出系统等功能
 */
public class SmallChangeSys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Wallet wallet = new Wallet(1000); // 初始化钱包1000元

//        int key = 1; // 用户选择
        String key = ""; // 优化key 为String,避免异常
        while (!"4".equals(key)) {
            wallet.getFunction().printMenu(); // 显示菜单
            key = scanner.next(); // 接收用户输入

            //根据选择显示对应项
            switch (key) {
                case "1": // 显示明细
                    wallet.getFunction().printDetail(wallet);
                    break;
                case "2": // 收益入账
                    System.out.println("请输入收益金额");
                    double inAmount = scanner.nextDouble();
                    wallet.income(inAmount);
                    break;
                case "3": // 消费
                    System.out.println("请输入消费商户名");
                    String name = scanner.next();
                    System.out.println("请输入消费金额");
                    double outAmount = scanner.nextDouble();
                    wallet.consume(name, outAmount);
                    break;
                case "4": // 退出
                    key = wallet.getFunction().isExit();
                    break;
                default:
                    System.out.println("输入错误,请重新输入");
//                    break;
            }
        }
    }
}
