package com.edu.houserent.utils;

public class TestUtility {
    public static void main(String[] args) {
        // 测试类
        String s = Utility.readString(3);
        System.out.println(s);

        String s1 = Utility.readString(5, "默认值");
        System.out.println(s1);

        char c = Utility.readConfirmSelection();
        System.out.println(c);
    }
}
