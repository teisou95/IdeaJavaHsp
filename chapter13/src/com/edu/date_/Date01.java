package com.edu.date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01 {
    public static void main(String[] args) throws ParseException {
        // java.util.Date
        Date date = new Date(); // 获取系统当前时间
        System.out.println(date); // 默认日期格式
        // 日期格式转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
        String format = simpleDateFormat.format(date); // 格式化 Date 对象
        System.out.println(format);

        Date date1 = new Date(999959984584L); // 传入毫秒数 (距离 1970-1-1)
        System.out.println(simpleDateFormat.format(date1));

        // 将格式化的字符串转为对应的 Date
        String s = "2003年05月08日 10:20:36 日";
        Date parse = simpleDateFormat.parse(s); // s 的格式要与 simpleDateFormat 格式一致
        System.out.println(simpleDateFormat.format(parse));

    }
}
