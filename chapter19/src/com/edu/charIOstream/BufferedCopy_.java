package com.edu.charIOstream;

import java.io.*;

/**
 * 拷贝文件 字符输入输出处理流
 * 字符流 不要用于 操作二进制文件(声音 视频 word doc pdf 图片 等),可能会造成文件损坏/数据损失
 */
public class BufferedCopy_ {
    public static void main(String[] args) throws IOException {
        String srcFilePath = "D:\\LinkedListCRUD.java";
        String destFilePath = "D:\\copy100.java";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFilePath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destFilePath));

        String line;
        // readLine 读取一行的内容,但是不会读取换行符
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine(); // 注意换行
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
