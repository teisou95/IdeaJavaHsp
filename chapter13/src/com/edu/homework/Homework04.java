package com.edu.homework;

public class Homework04 {
    public static void main(String[] args) {
        String str = "csdhSdnjaDsnjaDAJd25dsaDSbhajkds5a等哈时间d";
//        str = null;
        countString(str);
    }
    public static void countString(String str) {
        if (str == null) {
            System.out.println("不能为null");
            return;
        }
//        char[] chars = str.toCharArray();
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int numberCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                upperCaseCount++;
            }
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lowerCaseCount++;
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                numberCount++;
            }
        }
        int otherCount = str.length() - upperCaseCount - lowerCaseCount - numberCount;
        String formatStr = "大写字母%d个,小写字母%d个,数字%d个,其他字符%d个";
        System.out.println(String.format(formatStr,upperCaseCount,lowerCaseCount,numberCount,otherCount));
    }
}
