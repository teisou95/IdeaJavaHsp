package com.edu.charIOstream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流
 */
public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "D:\\note.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath,false);
            fileWriter.write("风雨之后,定见彩虹 ");
            fileWriter.write(215455); // 写入的是 int 对应的字符
            fileWriter.write('H');
            fileWriter.write(new char[]{'j','哈'},0,1);
            fileWriter.write("破反对",1,2);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close(); // 流如果不关闭或不刷新 数据实际不会写入
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
