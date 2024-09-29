package com.edu.date_;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDate_ {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 定制时间格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format = dateTimeFormatter.format(now);
        System.out.println("格式化的日期 " + format);
        System.out.println(now.getYear() + "年");
        System.out.println(now.getMonth() + "月"); // 英文
        System.out.println(now.getMonthValue() + "月"); // 月数
        System.out.println(now.getDayOfMonth() + "日");
        System.out.println(now.getHour() + "时");
        System.out.println(now.getMinute() + "分");
        System.out.println(now.getSecond() + "秒");
        System.out.println(now.getNano() + "纳秒");

        LocalDate now1 = LocalDate.now();
        System.out.println(now1);

        LocalTime now2 = LocalTime.now();
        System.out.println(now2);

        System.out.println(dateTimeFormatter.format((now.plusDays(892))));
        System.out.println(dateTimeFormatter.format(now.minusMinutes(2519)));
    }
}
