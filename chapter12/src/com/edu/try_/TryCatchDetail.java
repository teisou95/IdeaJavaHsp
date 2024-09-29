package com.edu.try_;

public class TryCatchDetail {
    public static void main(String[] args) {
        try {
            String str = "hahha";
            int a = Integer.parseInt(str); // 如果发生异常,直接跳进 catch
            System.out.println("数字:" + a); // 如果没有发生异常,try正常执行,然后跳出try-catch
        } catch (NumberFormatException e) {
            System.out.println("异常信息 " + e);
        } finally { // 不管有没有发生异常 都执行 finally
            System.out.println("finally 代码块被执行");
        }
        System.out.println("程序继续");
    }
}
