package com.edu.transformation;

import java.io.*;

// 转换流
// 指定编码方式 输出字符
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\demo.txt";
        String charset = "GBK";
//        String charset = "UTF8";
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath,false), charset));
        bufferedWriter.write("实际穿管kida是擦");
        bufferedWriter.newLine();
        bufferedWriter.write(102511);
        bufferedWriter.close();
        System.out.printf("按照%s 编码方式保存了文件",charset);
    }
}
