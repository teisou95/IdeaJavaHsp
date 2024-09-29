package com.edu.standard;

/**
 * 标准输入输出流
 * 对应 键盘 和 显示器
 */
public class StandardInputAndOutput {
    public static void main(String[] args) {
        // public final static InputStream in = null;
        System.out.println(System.in.getClass()); // class java.io.BufferedInputStream

        // public final static PrintStream out = null;
        System.out.println(System.out.getClass()); // class java.io.PrintStream
    }
}
