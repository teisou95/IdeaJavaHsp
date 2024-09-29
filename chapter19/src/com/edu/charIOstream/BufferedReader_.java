package com.edu.charIOstream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 处理流字符输入流
 */
public class BufferedReader_ {
    public static void main(String[] args) {
//        m1();
//        m2();
        m3();

    }

    public static void m1() {
        String filePath = "D:\\LinkedListCRUD.java";
        BufferedReader bufferedReader = null;
        int readDate = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((readDate = bufferedReader.read()) != -1) {
                System.out.print((char) readDate);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m2() {
        String filePath = "D:\\LinkedListCRUD.java";
        BufferedReader bufferedReader = null;
        char[] chars = new char[8];
        int readLen = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((readLen = bufferedReader.read(chars)) != -1) {
                System.out.print(new String(chars,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 按行读取 效率高
    public static void m3() {
        String filePath = "D:\\LinkedListCRUD.java";
        BufferedReader bufferedReader = null;
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            // 返回按行读取的内容 当返回 null 表示文件读取完毕
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bufferedReader != null) bufferedReader.close(); // 外层流关闭 会调用 底层节点流关闭 in. close
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
