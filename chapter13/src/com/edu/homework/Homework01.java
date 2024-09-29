package com.edu.homework;

/**
 * 反转字符串指定部分
 */
public class Homework01 {
    public static void main(String[] args) {
        String str = "start要反转 的部分啊end";
//        str = null;
        System.out.println(str);
        try {
            str = reverse(str, 5, 11);
            System.out.println(str);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @param str
     * @param start
     * @param end
     * @return
     */
    public static String reverse(String str, int start, int end) {
        // 手动反转1
        if (str == null) { // 过关斩将
            throw new NullPointerException("错误:输入字符串为空");
        }
        if (!(start >=0 && end < str.length() && start <end)) { // 过关斩将
            throw new ArrayIndexOutOfBoundsException("错误:索引不正确");
        }
        char[] chars = str.toCharArray(); // 转为 char 数组
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return new String(chars);


//        StringBuilder builder = new StringBuilder(str);
//
//        builder = builder.delete(0, start).delete(end - start + 1, builder.length());// 取出要反转的部分
//        StringBuilder builder1 = new StringBuilder(str).delete(start, str.length()); // 取出后的字符串前半部分
//        StringBuilder builder2 = new StringBuilder(str).delete(0, end + 1); // 取出后的字符串后半部分

//        StringBuilder builder3 = builder.reverse(); // 反转执行

        // 手动反转2 过于繁琐
//        char[] chars = builder.toString().toCharArray(); // 需要反转的部分 转为 char 数组
//        int midIndex = chars.length / 2; // 找到数组中间索引
//        char[] temp = new char[midIndex]; // 临时数组
//        for (int i = 0; i < temp.length; i++) {
//            temp[i] = chars[i]; // 保存 chars 数组 前半部分,赋值给 temp 数组
//            chars[i] = chars[chars.length - 1 - i]; // chars 数组的后半部分 反转赋值 给前半部分
//        }
//
//        if (chars.length % 2 == 0) { // 长度为偶数
//            for (int i = midIndex, j = temp.length - 1; i < chars.length; i++) {
//                chars[i] = temp[j]; // temp 数组 反转赋值给 chars 数组的后半部分
//                j--;
//            }
//        } else { // 长度为奇数
//            for (int i = midIndex + 1, j = temp.length - 1; i < chars.length; i++) {
//                chars[i] = temp[j]; // temp 数组 反转赋值给 chars 数组的后半部分
//                j--;
//            }
//        }
//        String s = new String(chars);
//        StringBuilder builder3 = new StringBuilder(s); // 反转结果
//
//        return builder1.append(builder3).append(builder2).toString(); // 拼接返回
    }
}
