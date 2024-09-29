package com.edu.properties_;

import java.io.*;
import java.util.Properties;

/**
 * Properties 类读取 配置文件,存入键值对
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        String filePath = "src\\mysql.properties";
        // 加载
        properties.load(new FileReader(filePath));
        // 显示到控制台
        properties.list(System.out);
        // 根据 key 获取 value
        String ip = properties.getProperty("ip");
        System.out.println("ip = " + ip);

        // 更新信息
        properties.setProperty("ip","100.100.10");
        properties.setProperty("pwd","2510000");
        properties.store(new FileWriter(filePath),"update pwd ");


    }
}
