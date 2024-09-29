package com.edu.byteIOstream;

import java.io.*;

/**
 * 字节处理流
 */
public class BufferedCopy02 {
    public static void main(String[] args) throws IOException {
        String srcFilePath = "C:\\Users\\teiso\\OneDrive\\桌面\\png素材\\tankGame.jpg";
        String destFilePath = "D:\\copy01.jpg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));

        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes,0,readLen);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
