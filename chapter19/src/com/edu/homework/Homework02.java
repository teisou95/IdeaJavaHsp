package com.edu.homework;

import java.io.*;

public class Homework02 {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\myTemp\\hello.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"GBK"));
//        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        // 在创建流时，即使还没有调用 write() 方法，文件内容也已经被清空了。
        String line;
//        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        while ((line = br.readLine()) != null) {
            System.out.println("第" + i++ + "行:" + line);
//            stringBuilder.append("第" + i++ + "行:" + line + "\n");
        }
//        System.out.println(stringBuilder);
        br.close();
//        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
//        bw.write(new String(stringBuilder));
//        bw.close();

    }
}
