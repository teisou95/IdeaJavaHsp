package com.edu.enumeration_;

import sun.java2d.pipe.AAShapePipe;

public class EnumerationExercise02 {
    public static void main(String[] args) {
        System.out.println("==所有星期的信息如下==");
        for (Week week :
                Week.values()) {
            System.out.println(week.getChineseName());
        }

        System.out.println("==所有星期的信息如下==");
        for (Week week :
                Week.values()) {
            System.out.println(week.name());
        }

        System.out.println("==所有星期的信息如下==");
        for (Week week :
                Week.values()) {
            System.out.println(week);
        }
    }
}

enum Week{
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期天");

    private String chineseName;
    Week(String chineseName) {
        this.chineseName = chineseName;
    }

    @Override
    public String toString() {
        return "Week{" +
                "chineseName='" + chineseName + '\'' +
                '}';
    }

    public String getChineseName() {
        return chineseName;
    }
}