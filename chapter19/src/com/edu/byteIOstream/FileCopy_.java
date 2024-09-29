package com.edu.byteIOstream;

import java.io.*;

/**
 * 文件拷贝
 * 当文件流保持打开状态时，写入的数据是顺序追加到文件中的，即使没有使用追加模式。
 * 追加模式只有在反复打开文件流的情况下有用；在一个写入过程中的多次写入，不需要追加模式也会顺序写入数据。
 */
public class FileCopy_ {
    public static void main(String[] args) {
        String srcFilePath = "C:\\Users\\teiso\\OneDrive\\桌面\\png素材\\tankGame.jpg";
        String destFilePath = "D:\\copy.jpg";
        File srcFile = new File(srcFilePath);
        File destFile = new File(destFilePath);

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        byte[] buffer = new byte[1024];
        int readLength = 0;

        try {
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile); // 在循环外面打开文件流,提高效率
//            fileOutputStream = new FileOutputStream("D:\\copy.jpg"); // 两种写法都可以,一样的
            while ((readLength = fileInputStream.read(buffer)) != -1) {
                // 每次读取后写入,边读边写
                fileOutputStream.write(buffer,0,readLength);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }

                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
