package com.edu.homework.t03;

public class Lecturer extends Teacher{
    public Lecturer(String name, int age, double salary) {
        super(name, age, salary);
        setPost("讲师");
        setGrade(1.1);
    }

    @Override
    public void introduce() {
        super.introduce();
    }
}
