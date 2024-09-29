package com.edu.generic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

public class GenericExercise02 {
    public static void main(String[] args) {
        Employee jack = new Employee("jack", 12000, new MyDate(1987, 5, 13));
        Employee tom = new Employee("tom", 2400, new MyDate(1967, 1, 10));
        Employee king = new Employee("king", 6000, new MyDate(1998, 12, 20));
        Employee jack2 = new Employee("jack", 12000, new MyDate(1987, 1, 13));

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(jack);
        employees.add(tom);
        employees.add(king);
        employees.add(null); // 指定泛型后 null 还是可以加入
        employees.add(jack2);

        // 定制排序
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1 == null || e2 == null) {
                    System.out.println("出现null");
                    return 0; // null 会被甩到最后
                }
                int i = e1.getName().compareTo(e2.getName());
                if (i != 0) {
                    return i; // 先按 name 比较
                }
                return e1.getBirthday().compareTo(e2.getBirthday()); // 再按 birthday 比较

            }
        });

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee);
        }
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}


class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    @Override
    public String toString() {
        return year + "年" + month + "月" + day + "日";
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public int compareTo(MyDate date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String str1 = String.format("%04d年%02d月%02d日", year, month, day); // 少位补0
        String str2 = String.format("%04d年%02d月%02d日", date.year, date.month, date.day);
        System.out.println(str1);
        System.out.println(str2);
        Date date1 = null; //  public Date parse(String source) throws ParseException
        Date date2 = null;
        try {
            date1 = sdf.parse(str1);
            date2 = sdf.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1.compareTo(date2);
    }

//    public int compareTo(MyDate date) throws ParseException {
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
////        String s1 = "0000" + year;
////        String s2 = "00" + month;
////        String s3 = "00" + day;
////        String str1 = s1.substring(s1.length() - 4) + "年" +
////                s2.substring(s2.length() - 2) + "月" + s3.substring(s3.length() - 2) + "日";
////         s1 = "0000" + date.year;
////         s2 = "00" + date.month;
////         s3 = "00" + date.day;
////        String str2 = s1.substring(s1.length() - 4) +
////                s2.substring(s2.length() - 2) + s3.substring(s3.length() - 2);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//        String str1 = String.format("%04d年%02d月%02d日", year, month, day);
//        String str2 = String.format("%04d年%02d月%02d日", date.year, date.month, date.day);
//        System.out.println(str1);
//        System.out.println(str2);
//        Date date1 = sdf.parse(str1); //  public Date parse(String source) throws ParseException
//        Date date2 = sdf.parse(str2);
//        return date1.compareTo(date2);
//
//
////        if (year != date.year) {
////            return year - date.year;
////        }
////        if (month != date.month) {
////            return month - date.month;
////        }
////        return day - date.day;
//    }

}
