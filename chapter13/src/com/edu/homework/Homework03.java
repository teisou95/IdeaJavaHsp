package com.edu.homework;

import java.util.Arrays;

public class Homework03 {
    public static void main(String[] args) {
        String name = "Willian Jefferson Clinton";
//        name = null;
        try {
            String nameFormat = namePush(name);
            System.out.println("nameFormat = " + nameFormat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static String namePush(String name) {
        if (name == null) {
            throw new NullPointerException("名字不能为null");
        }
//        char[] chars = name.toCharArray();
//        int count = 0;
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == ' ') {
//                count++;
//            }
//        }
//        if (!(count == 2)) {
//            throw new RuntimeException("名字必须有且仅有2个空格");
//        }
        String[] names = name.split(" ");
        System.out.println(Arrays.toString(names));
        if (names.length != 3) {
            throw new RuntimeException("名字必须有且仅有2个空格");
        }
        // 格式化 format 方法
        return String.format("%s,%s.%c",names[2],names[0],names[1].toUpperCase().charAt(0));
    }
}
