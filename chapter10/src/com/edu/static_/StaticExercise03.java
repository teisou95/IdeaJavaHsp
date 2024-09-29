package com.edu.static_;

public class StaticExercise03 {
    // main 方法是 java 虚拟机在调用,访问权限必须是 public
    // java 虚拟机调用时,不创建对象,所有必须是 static 方法
    public static void main(String[] args) {
        Person03.setTotal(3); // Person03.total = 3
        new Person03(); // Person03.total = 4, new Person03().id = 4
        System.out.println(Person03.getTotal()); // 4
    }
}
class Person03 {
    private int id;
    private static int total = 0;

    public static void setTotal(int total) {
//        this.total = total; // 静态成员不能使用 this super 关键字
        Person03.total = total;
    }

    public static int getTotal() {
        return total;
    }

    public Person03() {
        total++;
        id = total;
    }
}
