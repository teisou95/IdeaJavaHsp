package com.edu.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 抛出异常
 */
public class Throws01 {
    public static void main(String[] args) {
        try {
            new Throws01().f1();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void f1() throws FileNotFoundException, NullPointerException{ // 让调用 f1 方法的 调用者(方法)处理抛出的异常
        // 创建了一个文件流对象
//        try {
//            FileInputStream fis = new FileInputStream("d://aa.txt");
//        } catch (FileNotFoundException e) { // 编译异常
//            System.out.println(e); // java.io.FileNotFoundException: d:\aa.txt (系统找不到指定的文件。)
//        }
        FileInputStream fis = new FileInputStream("d://aa.txt");
    }
}
