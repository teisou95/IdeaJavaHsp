package com.edu.charIOstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 处理流 字符输出流
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\copy1.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
        bufferedWriter.write("hello,java流");
//        bufferedWriter.write("\n");
        bufferedWriter.newLine(); //插入一个和系统匹配的换行符
        bufferedWriter.write("hello,sekai101",0,10);
        bufferedWriter.close();
    }
}
