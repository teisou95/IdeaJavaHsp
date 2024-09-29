package com.edu.file;

import com.sun.javafx.binding.StringFormatter;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件
 */
public class FileCreate {
    public static void main(String[] args) {

    }
    @Test
    public void create01() {
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);


        try {
            file.createNewFile(); // 创建文件
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 父目录下创建
    @Test
    public void create02() {
        File parentFile = new File("D:\\"); // parent file 对象
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName); // 当前只是在内存中创建了对象

        try {
            file.createNewFile(); // 这里才真正创建了文件,写入到磁盘
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create03() {
        String parentFilePath = "D:\\";
//        String parentFilePath = "D:/"; // 也可以
        String childFileName = "news3.txt";
        File file = new File(parentFilePath, childFileName);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
