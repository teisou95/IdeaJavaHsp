package com.edu.houserent.service;

import com.edu.houserent.domain.House;
import com.edu.houserent.utils.Utility;

/**
 * 业务层
 * 1.响应 HouseView 的调用
 * 2.完成对房屋信息的各种操作(增删改查)
 * crud(creat-read-update-delete)
 * <p>
 * 优化项
 * 1.编号重复/房源重复排除
 * 2.数组按编号重新排序
 * 3.状态校验
 */
public class HouseService {
    private House[] houses = new House[0];
    private int defaultHouseId = 0;

    /**
     * 各司其职,界面写在界面层,这里只返回数据
     *
     * @return 全部房屋信息的数组
     */
    public House[] getHouses() {
        return houses;
    }

    /**
     * case '1'
     * 新增房源信息
     * int houseId, String name, String phone, String address, int rent, String state
     */
    public void addHouse() {
        House house = new House(); // 新增房源

        // 按输入信息赋值新房屋对象各项属性
        // 编号重复校验
        System.out.print("请输入房屋编号(10位以内):");
        int checkHouseId = Utility.readInt( defaultHouseId + 1);
        while (checkHouse(checkHouseId, -1)) { //如果与已有编号重复
            checkHouseId = Utility.readInt(defaultHouseId + 1); // 重新读取
        }
        house.setHouseId(checkHouseId);
        defaultHouseId = house.getHouseId(); // 默认编号依次增加

        System.out.print("请输入房主姓名(10字以内):");
        house.setName(Utility.readString(10, "匿名"));

        System.out.print("请输入联系电话(11位以内):");
        house.setPhone(Utility.readString(11, "未知"));

        // 地址重复校验
        System.out.print("请输入地址(20字以内):");
        String checkHouseAddress = Utility.readString(20, "暂未获取");
        while (checkHouse(checkHouseAddress, -1)) {
            checkHouseAddress = Utility.readString(20, "暂未获取");
        }
        house.setAddress(checkHouseAddress);

        System.out.print("请输入月租金(5位数以下整数,默认 -9999):");
        house.setRent(Utility.readInt(-9999));

        // 状态合法性校验
        System.out.print("请输入当前状态(已出租/未出租):");
        String checkHouseState = Utility.readString(3, "未知");
        while (checkHouse(checkHouseState)) {
            checkHouseState = Utility.readString(3, "未知");
        }
        house.setState(checkHouseState);


        // 扩增房屋数组,纳入新对象
        House[] housesUpdate = new House[houses.length + 1];
        if (housesUpdate.length > 1) { // 原数组不为空时,新数组对齐取值原数组
            for (int i = 0; i < houses.length; i++) {
                housesUpdate[i] = houses[i];
            }
        }
        housesUpdate[housesUpdate.length - 1] = house; // 添加至新数组最后
        houses = housesUpdate; // 更新至原房屋数组

        // 打印新增信息
        System.out.println("--------------新增房屋如下-------------");
        System.out.println("编号 房主\t电话\t地址\t月租\t状态(已出租/未出租)");
        System.out.println(houses[houses.length - 1].toString() + "\n");
    }

    /**
     * 工具:查找目标
     * 按编号返回目标索引
     * 打印相关信息
     *
     * @param targetHouseId 要寻找的目标房屋编号
     * @return 目标索引
     */
    public int findIndex(int targetHouseId) {
        int index = -1; // 目标房屋索引

        // 遍历数组寻找目标
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getHouseId() == targetHouseId) {
                index = i; // 索引赋值
                break;
            }
        }

        if (index == -1) { // 没找到
            System.out.println("没有编号" + targetHouseId + "的房屋");
            return index; // 结束方法,返回索引
        }

        // 找到了,打印
        System.out.println("--------------找到编号" + targetHouseId + "房屋如下-------------");
        System.out.println("编号 房主\t电话\t地址\t月租\t状态(已出租/未出租)");
        System.out.println(houses[index].toString() + "\n");

        // 返回索引
        return index;
    }

    /**
     * case '2'
     * 按编号查找房屋
     */
    public void findHouse() {
        System.out.println("请输入要查找的房屋编号:");
        int findHouseId = Utility.readInt();
        findIndex(findHouseId); // 查找返回索引
    }

    /**
     * case '3'
     * 按编号删除房屋
     */
    public void deleteHouse() {
        System.out.println("请输入要删除的房屋编号:");
        int deleteHouseId = Utility.readInt();
        int index = findIndex(deleteHouseId); // 查找返回索引

        if (index == -1) {
            return; // 没找到直接结束
        }

        // 找到了目标,确认是否删除
        System.out.println("请确认是否删除此房屋(Y/N):");
        if (Utility.readConfirmSelection() == 'N') {
            System.out.println("放弃删除,返回主菜单");
            return;
        }

        // 删除目标,更新数组
        House[] houseUpdate = new House[this.houses.length - 1];
        for (int i = 0, j = 0; i < houses.length; i++) {
            if (i == index) { // 到目标跳过
                continue;
            }
            houseUpdate[j] = houses[i]; // 双指针错位对齐取值
            j++;
        }

        houses = houseUpdate; // 更新至原房屋数组(原数组顺序没变)
        System.out.println("--------------已删除编号" + deleteHouseId + "房屋-------------");
    }

    /**
     * case '4'
     * 按编号修改房屋信息
     */
    public void modifyHouse() {
        System.out.println("请输入要修改的房屋编号");
        int modifyHouseId = Utility.readInt();
        int index = findIndex(modifyHouseId); // 查找返回索引
        if (index == -1) {
            return; //没找到直接结束
        }

        // 找到了,开始逐项修改
        // int houseId, String name, String phone, String address, int rent, String state
        // 编号重复校验
        System.out.print("目标房屋编号为" + houses[index].getHouseId()
                + ",请更新(直接回车将不更新,直接进入下一项):");
        int checkHouseId = Utility.readInt(houses[index].getHouseId());
        while (checkHouse(checkHouseId, index)) {
            checkHouseId = Utility.readInt(houses[index].getHouseId());
        }
        houses[index].setHouseId(checkHouseId);

        System.out.print("目标房屋房主为" + houses[index].getName()
                + ",请更新(直接回车将不更新,直接进入下一项):");
        houses[index].setName(Utility.readString(10, houses[index].getName()));

        System.out.print("目标房屋电话为" + houses[index].getPhone()
                + ",请更新(直接回车将不更新,直接进入下一项):");
        houses[index].setPhone(Utility.readString(11, houses[index].getPhone()));

        // 地址重复校验
        System.out.print("目标房屋地址为" + houses[index].getAddress()
                + ",请更新(直接回车将不更新,直接进入下一项):");
        String checkHouseAddress = Utility.readString(20, houses[index].getAddress());
        while (checkHouse(checkHouseAddress, index)) {
            checkHouseAddress = Utility.readString(20, houses[index].getAddress());
        }
        houses[index].setAddress(checkHouseAddress);

        System.out.print("目标房屋月租为" + houses[index].getRent()
                + ",请更新(直接回车将不更新,直接进入下一项):");
        houses[index].setRent(Utility.readInt(houses[index].getRent()));

        // 状态合法性校验
        System.out.print("目标房屋状态为" + houses[index].getState()
                + ",请更新(直接回车将不更新,直接进入下一项):");
        String checkHouseState = Utility.readString(3, houses[index].getState());
        while (checkHouse(checkHouseState)) {
            checkHouseState = Utility.readString(3, houses[index].getState());
        }
        houses[index].setState(checkHouseState);

        // 更新完毕,打印
        System.out.println("--------------更新原编号" + modifyHouseId + "房屋如下-------------");
        System.out.println("编号 房主\t电话\t地址\t月租\t状态(已出租/未出租)");
        System.out.println(houses[index].toString() + "\n");

    }

    /**
     * case '6'
     * 退出系统
     */
    public boolean exit() {
        System.out.println("你确认要退出吗?请输入选择(Y/N):");
        if (Utility.readConfirmSelection() == 'Y') {
            System.out.println("退出了房屋出租系统");
            return false;
        }
        System.out.println("放弃退出,返回主菜单");
        return true;
    }

    /**
     * 数组按编号从小到大排序
     * 冒泡排序
     */
    public void sortArrayHouse(House[] houses) {
        for (int i = 0; i < houses.length - 1; i++) {
            boolean exchange = false; // 某次内循环是否发生了交换
            for (int j = 0; j < houses.length - 1 - i; j++) {
                if (houses[j].getHouseId() > houses[j + 1].getHouseId()) {
                    House temp = houses[j];
                    houses[j] = houses[j + 1];
                    houses[j + 1] = temp;
                    exchange = true; // 发生了交换
                }
            }
            if (!exchange) { // 某次内循环未发生交换
                return; // 说明数组已有序,提前结束排序
            }
        }
    }


    /**
     * 编号如果相同,视为重复,不允许新增或变更
     *
     * @param checkHouseId 待检查的房屋编号
     * @param index        修改房屋信息时,排除修改对象自身的索引,新增对象时传入 -1
     * @return 布尔值, 重复返回 true
     */
    public boolean checkHouse(int checkHouseId, int index) {
        for (int i = 0; i < houses.length; i++) {
            if (i == index) {
                continue; // 排除自身
            }
            if (checkHouseId == houses[i].getHouseId()) {
                System.out.println("与已有的房屋编号出现重复,请换一个编号:");
                return true; //出现重复
            }
        }
        return false; // 没有重复
    }


    /**
     * 地址如果相同,视为重复,不允许新增或变更
     *
     * @param checkHouseAddress 待检查的房屋编号
     * @param index             修改房屋信息时,排除修改对象自身的索引,新增对象时传入 -1
     * @return 布尔值, 重复返回 true
     */
    public boolean checkHouse(String checkHouseAddress, int index) {
        if (checkHouseAddress.equals("暂未获取")) {
            return false; // 默认值的话不是重复,直接返回
        }
        for (int i = 0; i < houses.length; i++) {
            if (i == index) {
                continue; // 排除自身
            }
            if (checkHouseAddress.equals(houses[i].getAddress())) {
                System.out.println("与已有的房屋地址出现重复,请换一个地址:");
                return true; //出现重复
            }
        }
        return false; // 没有重复
    }

    /**
     * 状态只允许三种情况:已出租/未出租/未知
     *
     * @param checkHouseState 待检查的状态描述
     * @return 布尔值, 合法状态返回 false
     */
    public boolean checkHouse(String checkHouseState) {
        if (checkHouseState.equals("已出租")
                || checkHouseState.equals("未出租")
                || checkHouseState.equals("未知")) {
            return false;
        }
        System.out.println("状态描述有误,请重新输入:");
        return true;
    }
}