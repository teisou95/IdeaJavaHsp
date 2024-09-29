package com.edu.stringbuffer_;

/**
 * StringBuffer 类
 * 效率高于 String 类
 */
public class StringBuffer01 {
    public static void main(String[] args) {
        // StringBuffer 的 直接父类 抽象类 AbstractStringBuilder
        // 实现了 Serializable 可串行化
        // 父类中 char[] value 不是 final,存在字符串内容,在堆中,不在常量池
        // final 类,不能被继承
        // 更新内容时不用每次更新地址(创建新的对象),只有在空间不够时再变更地址扩大空间
        StringBuffer stringBuffer = new StringBuffer("hello");
    }
}
