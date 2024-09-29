package com.edu.homework.t10;

import java.util.Objects;

public class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Doctor(String name, int age, String job, char gender, double salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return age == doctor.age &&
                gender == doctor.gender &&
                Double.compare(doctor.salary, salary) == 0 &&
                Objects.equals(name, doctor.name) &&
                Objects.equals(job, doctor.job);
    }

    /*
     * 一般重写 equals 需要一并重写 hashCode
     * 目的是让内容相同的对象,hashCode也相同
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age, job, gender, salary);
    }
}
