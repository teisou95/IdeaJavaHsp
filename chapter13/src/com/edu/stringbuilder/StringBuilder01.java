package com.edu.stringbuilder;

// 单线程优先使用 StringBuilder
// 存在线程安全问题
// final 类
// 直接父类AbstractStringBuilder
public class StringBuilder01 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
    }
}
