package com.edu.houserent;

import com.edu.houserent.view.HouseView;

/**
 *
 * 程序框架图(分层模式)
 * 1.系统有哪些类(文件)
 * 2.明确类与类的调用关系
 *
 * 1.工具类准备
 * 2.domain类准备
 * 3.项目功能实现
 *  3.1显示主菜单/完成退出软件功能
 *  3.2各项菜单功能
 *  3.3尽量复用方法
 * 4.优化调整测试
 *
 * 房屋出租系统 App
 * 程序主入口
 * 创建 HouseView 对象
 * 调用该对象显示主菜单
 */
public class HouseRentApp {
    public static void main(String[] args) {
        // 创建 HouseView 对象
        new HouseView().mainMenu();
    }
}

