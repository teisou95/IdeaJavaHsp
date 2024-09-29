/*
    封装
    将属性和方法封装,数据被保护在内部
    程序的其他部分只有通过被授权的方法,才能对数据进行操作
    封装实现步骤:
    1. private 属性私有化
    2. public set方法,加入数据验证
    3. public get方法,加入权限判断
 */
package com.edu.encap;

public class Encapsulation01 {
    public static void main(String[] args) {
        // 参数提示设置:editor-inlay hints
        Person person = new Person("king", 6000, 6000.5, "社员");
        System.out.println("name = " + person.getName());
        System.out.println("age = " + person.getAge(123456));
        System.out.println("salary = " + person.getSalary(123456));
        System.out.println("job = " + person.getJob(123456));

    }
}

class Person {
    public String name; // 名字公开
    private int age; // 私有化
    private double salary;
    private String job;

    // 快捷键 alt+insert

    public Person() {
    }

    public Person(String name, int age, double salary, String job) {
        // 构造器与set方法结合
        setName(name);
        setAge(age);
        this.salary = salary;
        this.job = job;
    }

    public void setName(String name) {
        if (name != null && name.length() > 1 && name.length() < 7) {
            this.name = name;
        } else {
            System.out.println("name 长度必须在2~6字符之间");
        }
    }

    public void setAge(int age) {
        if (age > 0 && age < 121) {
            this.age = age;
        } else {
            System.out.println("设置年龄不合理,默认设置为25岁");
            this.age = 25;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getAge(int password) {
        return isPass(password) ? age : null;
    }

    public Double getSalary(int password) {
        return isPass(password) ? salary : null;
    }

    public String getJob(int password) {
        return isPass(password) ? job : null;
    }

    public boolean isPass(int password) {
        if (password == 123456) {
            System.out.println("密码正确,数据如下");
            return true;
        } else {
            System.out.println("密码错误,无法访问");
            return false;
        }
    }

}
