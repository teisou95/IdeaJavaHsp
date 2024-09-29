package com.edu.transformation;

import sun.nio.cs.UTF_32BE;
import sun.nio.cs.ext.GBK;

import java.io.*;

/**
 * 转换流
 * 字节流 <==> 字符流
 * 解决乱码问题
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        m1();
        m2();
    }

    public static void m1() throws IOException {
        String filePath = "D:\\a.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        // 默认按照 UTF-8读取,如果文件不是 UTF-8编码,可能出现乱码
        // 没有指定读取文件的编码方式
        // 转换流 可以将将字节流 按照指定编码方式 转换为字符流 解决问题
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
    public static void m2() throws IOException {
        String filePath = "D:\\a.txt";
        // 字节流 指定 编码方式 转换为字符流 再包装成 BufferedReader
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),new GBK()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"gbk"));

        char[] chars = new char[5];
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.print(line);
        }
        bufferedReader.close();
    }

}
