package com.edu.houserent.domain;

import java.util.Objects;

/**
 * domain/model/数据层/实体层
 * 一个 House 对象表示一个房屋信息
 */
public class House {
    private int houseId; // 房屋编号
    private String name; // 房主
    private String phone; // 电话
    private String address; // 地址
    private int rent; // 月租
    private String state; // 状态 (已出租/未出租)


    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // 输出房屋信息,格式如下
    // 编号   房主  电话  地址  月租  状态(已出租/未出租)
    @Override
    public String toString() {
        return houseId + "\t" + name + "\t" + phone + "\t" + address + "\t" + rent + "\t" + state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return houseId == house.houseId &&
                rent == house.rent &&
                Objects.equals(name, house.name) &&
                Objects.equals(phone, house.phone) &&
                Objects.equals(address, house.address) &&
                Objects.equals(state, house.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseId, name, phone, address, rent, state);
    }
}
