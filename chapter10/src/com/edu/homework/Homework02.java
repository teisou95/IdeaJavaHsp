package com.edu.homework;

public class Homework02 {
    public static void main(String[] args) {
//        System.out.println(Frock.getNextNum());
//        System.out.println(Frock.getNextNum());
        Frock frock = new Frock();
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        System.out.println("frock = " + frock.getSerialNumber());
        System.out.println("frock1 = " + frock1.getSerialNumber());
        System.out.println("frock2 = " + frock2.getSerialNumber());
    }
}
class Frock {
    private int serialNumber; // 序列号
    private static int currentNum = 100000; // 衣服出厂的序列号起始值
    public static int getNextNum() {
        currentNum += 100;
        return currentNum - 100;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public Frock() {
        this.serialNumber = getNextNum();
    }
}