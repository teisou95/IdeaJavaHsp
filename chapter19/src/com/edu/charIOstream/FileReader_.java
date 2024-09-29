package com.edu.charIOstream;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {
        m1();
        m2();
    }

    /**
     * 单个字符读取文件
     */
    public static void m1() {
        String filePath = "D:\\story.txt";
        FileReader fileReader = null;
        int readDate;
        StringBuilder str = new StringBuilder();
        try {
            fileReader = new FileReader(filePath);
            // 返回实际读取的字符
            while ((readDate = fileReader.read()) != -1) { // 按字符读取
                str.append((char) readDate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(str);
    }

    /**
     * 字符数组读取文件
     */
    public static void m2() {
        String filePath = "D:\\story.txt";
        FileReader fileReader = null;
        char[] buf = new char[8];
        int readLength = 0;
        StringBuilder str = new StringBuilder();
        try {
            fileReader = new FileReader(filePath);
            // 返回实际读取到的字符数
            while ((readLength = fileReader.read(buf)) != -1) {
                str.append(buf, 0, readLength);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(str);
    }

}
