package com.edu.try_;

public class TryCatchDetail03 {
    public static void main(String[] args) {
        try {
            int n1 = 10;
            int n2 = 0;
            System.out.println(n1 / n2);
        } finally { // 发生了异常,但是仍然执行 finally ,程序崩溃
            System.out.println("执行了 finally");
        }
        System.out.println("程序继续..."); // 不执行

    }
}
