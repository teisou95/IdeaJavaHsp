package com.edu.printsream_;

import java.io.IOException;
import java.io.PrintStream;

/**
 * 字节打印流
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        out.print("john");
        out.write("酷酷酷".getBytes());
        /*
        public void print(String s) {
            if (s == null) {
                s = "null";
            }
            write(s);
        }
         */
//        out.close();
        System.out.println("jcs"); // 标准打印流如果关闭了,后面不能再打印

        // 修改打印流输出的位置
        System.setOut(new PrintStream("D:\\yy.txt"));
        System.out.println("哈哈哈");
        // System.out 是标准输出流，由 JVM 管理，不需要手动关闭。
    }
}
