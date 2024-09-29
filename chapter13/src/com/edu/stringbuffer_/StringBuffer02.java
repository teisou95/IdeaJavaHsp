package com.edu.stringbuffer_;

/**
 * StringBuffer 构造器
 */
public class StringBuffer02 {
    public static void main(String[] args) {
        // 创建一个容量16的char数组
        StringBuffer stringBuffer = new StringBuffer();

        // 通过构造器指定 char[] 大小
        StringBuffer stringBuffer1 = new StringBuffer(100);

        // 给一个 String 创建 StringBuffer
        // char[] 大小为 传入字符串长度 + 16
        StringBuffer hello = new StringBuffer("hello");
    }
}
