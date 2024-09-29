package com.edu.file;

import org.junit.Test;

import java.io.File;

/**
 * 获取文件信息
 */
public class FileInformation {
    public static void main(String[] args) {

    }

    @Test
    public void info() {
        File file = new File("D:\\news1.txt");
        File absoluteFile = file.getAbsoluteFile();
        System.out.println("absoluteFile = " + absoluteFile);

        // 文件名
        String name = file.getName();
        System.out.println("name = " + name);

        // 绝对路径
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);

        // 父级目录
        String parent = file.getParent();
        System.out.println("parent = " + parent);

        // 文件大小 按字节统计
        // UTF-8编码方式中 字母数字 1 字节 汉字 3字节
        long length = file.length();
        System.out.println("length = " + length);

        // 文件是否存在
        boolean exists = file.exists();
        System.out.println("exists = " + exists);

        // 是不是一个文件
        boolean fileFile = file.isFile();
        System.out.println("fileFile = " + fileFile);

        // 是不是一个目录
        boolean fileDirectory = file.isDirectory();
        System.out.println("fileDirectory = " + fileDirectory);
    }
}
