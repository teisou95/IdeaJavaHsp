package com.edu.homework;

import java.io.*;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        String dirPath = "D:\\myTemp";
        File dir = new File(dirPath);
        if (!dir.exists()){
            if (dir.mkdir()) {
                System.out.println("创建" + dirPath + "成功");
            } else {
                System.out.println("创建" + dirPath + "失败");
            }
        }

        String filePath = "hello.txt";
        File file = new File(dirPath, filePath);


        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("创建" + filePath + "成功");

            } else {
                System.out.println("创建" + filePath + "失败");
            }
        } else {
            System.out.println("文件" + filePath + "已存在");
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("hello,word~哈哈哈\n换个活法有人回复\n还是觉得零零六年\n哦LOL odd\n蓬莱岛是");
        bw.close();
    }
}
