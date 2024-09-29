package com.edu.file;

import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 目录操作
 */
public class Directory_ {
    public static void main(String[] args) {
        //
    }

    @Test
    public void m1() {
        File file = new File("D:\\news3.txt");
        boolean exists = file.exists();
        System.out.println("exists = " + exists);
        if (exists) {
            file.delete(); // 删除文件
            System.out.println(file.getName() + "删除成功");
        } else {
            System.out.println(file.getName() + "该文件不存在");
        }
    }

    // java 中,目录也被当作文件类型
    @Test
    public void m2() {
        File file = new File("D:\\demo");
        if (file.exists()) {
            file.delete();
            System.out.println(file.getName() + "删除成功"); // 实际删除失败,因为不是空目录,只能删除空目录
        } else {
            System.out.println(file.getName() + " 目录不存在");
        }
        System.out.println("file = " + file.exists());
    }

    @Test
    public void m3() {
        String directoryPath = "D:\\demo"; // \\a\\b\\c";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println("目录已存在");
        } else {
            if(file.mkdir()){ // 一级目录创建mkdir 多级目录创建mkdirs
                System.out.println("创建成功");
            }
        }
    }
}
