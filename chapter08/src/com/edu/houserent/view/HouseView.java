package com.edu.houserent.view;


import com.edu.houserent.domain.House;
import com.edu.houserent.service.HouseService;
import com.edu.houserent.utils.Utility;

/**
 * 界面层
 * 1.显示界面
 * 2.接收用户的输入
 * 3.调用 HouseService 完成对房屋的各种操作
 */
public class HouseView {
    HouseService service = new HouseService();

    /**
     * 显示主菜单
     * 功能: 用户打开软件,可以看到主菜单,可以选择操作
     */
    public void mainMenu() {
        boolean loop = true;
        char choice = 0;
        do {
            System.out.println("--------------房屋出租系统--------------");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退       出");
            choice = Utility.readMenuSelection();
            switch (choice) {
                case '1': // 新增房源
                    service.addHouse();
                    break;
                case '2': // 查找房屋
                    service.findHouse();
                    break;
                case '3': // 删除房屋
                    service.deleteHouse();
                    break;
                case '4': // 修改房屋信息
                    service.modifyHouse();
                    break;
                case '5': // 房屋列表
                    listHouse();
                    break;
                case '6': // 退出系统
                    loop = service.exit();
                    break;
            }
        } while (loop);
    }

    /**
     * 功能: 房屋列表信息界面
     * 格式: 编号   房主  电话  地址  月租  状态(已出租/未出租)
     */
    public void listHouse() {
        System.out.println("--------------全部房源信息-------------");
        System.out.println("编号 房主\t电话\t地址\t月租\t状态(已出租/未出租)");
        House[] houses = service.getHouses();
        service.sortArrayHouse(houses); // 打印之前排个序
        for (int i = 0; i < houses.length; i++) {
            System.out.println(houses[i].toString());
        }
        System.out.println();
    }
}
