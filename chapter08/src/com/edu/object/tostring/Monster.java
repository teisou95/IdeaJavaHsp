package com.edu.object.tostring;

public class Monster {
    private String name;
    private String job;
    private double sal;

    public Monster(String name, String job, double sal) {
        this.name = name;
        this.job = job;
        this.sal = sal;
    }
    // 重写 toString
//    public String toString() {
//        return "name = " + name + " job = " + job + " sal = " + sal;
//    }

    @Override
    public String toString() { // 默认重写
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }
}

