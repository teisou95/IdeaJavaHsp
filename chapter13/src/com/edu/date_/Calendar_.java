package com.edu.date_;

import java.util.Calendar;

public class Calendar_ {
    public static void main(String[] args) {
//        Calendar 是一个抽象类,且构造器是私有化的
        Calendar calendar = Calendar.getInstance(); // 获取实例
        System.out.println(calendar.get(Calendar.YEAR) + "年");
        // 月份默认从 0 开始计算
        System.out.println(calendar.get(Calendar.MONTH) + 1 + "月");
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH) + "日");
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + "时");
        System.out.println(calendar.get(Calendar.MINUTE) + "分");
        System.out.println(calendar.get(Calendar.SECOND) + "秒");
        // 格式自己组合
    }
}
