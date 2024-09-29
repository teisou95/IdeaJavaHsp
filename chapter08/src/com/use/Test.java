package com.use;

import com.xiaoqiang.Dog;

import java.util.Random;
import java.util.Scanner;
//import com.xiaoming.Dog; // com.xiaoqiang.Dog' is already defined in a single-type import

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog); // com.xiaoqiang.Dog@4554617c

        com.xiaoming.Dog dog1 = new com.xiaoming.Dog();
        System.out.println(dog1); // com.xiaoming.Dog@74a14482
        System.out.println(Math.abs(-1)); // java.lang 默认引入包
        Scanner scanner = new Scanner(System.in); // java.util 工具包
        Random random = new Random(); // java.util 工具包
        // java.net 网络包
        // java.awt java界面开发,GUI
    }
}
