package com.edu.wrapper_;

/**
 * 包装类和 String 相互转换
 */
public class WrapperVSString {
    public static void main(String[] args) {
        // 包装类转String
        Integer i = 100;
        String s1 = i + ""; // 新建了 字符串对象 赋给 s1, i 的类型没变
        String s2 = i.toString();
        String s3 = String.valueOf(i);

        // String 转包装类
        String str = "12345";
        Integer i1 = Integer.parseInt(str);
        Integer i2 = new Integer(str);
    }
}
