package com.edu.byteIOstream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字节输入流
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 读取文件
     * read()单个字节的读取,效率低
     * read(byte[] b) 最多读取b.length 长度的字节,给字节数组,效率较高
     */
    @Test
    public void readFile1() {
        String filePath = "D:\\hello.txt";
        int readDate = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath); // 创建流对象,用于读取文件
            while ((readDate = fileInputStream.read()) != -1) {
                // 读取一个字节数据,-1表示文件读取完毕,读出来是int
                System.out.print((char) readDate); // 转为 char
                // 文件中如果含有汉字,会乱码,因为汉字不止一个字节,每次被读取的只是汉字字符的其中一个字节,转char成乱码
                // 文本文件最好用字符流
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally { // 关闭流,释放文件连接,避免资源浪费
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * read(byte[] b) 最多读取b.length 长度的字节,给字节数组,效率较高
     */
    @Test
    public void readFile2() {
        String filePath = "D:\\hello.txt";
        byte[] buffer = new byte[8]; // 一次读取8个字节
        int readLength = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            // 字节数组每次循环读取8个字节,循环更新数组内容
            while ((readLength = fileInputStream.read(buffer)) != -1) {
                // 返回的是每次实际读取到的字节数,全部读完再读就返回- 1
//                String s = new String(buffer, 0, buffer.length); // 这样会读取到没更新的上一次读取的字节
                String s = new String(buffer, 0, readLength);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
