package com.edu.stringbuilder;

/**
 * String 效率低 复用率高 不可变字符序列
 * StringBuffer 效率高 可变 线程安全
 * StringBuilder 效率最高 可变 线程不安全
 * 存在大量修改 String操作时,不要使用 String
 */
public class StringVSStringBufferVSStringBuilder {
    public static void main(String[] args) {
        String text = "";
        StringBuffer buffer = new StringBuffer();
        StringBuilder builder = new StringBuilder();
        long startTime = 0L;
        long endTime = 0L;
        int count = 100000;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer 执行时间 " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer 执行时间 " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder 执行时间 " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            text += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String 执行时间 " + (endTime - startTime));
    }
}
