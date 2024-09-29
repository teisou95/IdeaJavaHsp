package com.edu.homework.t03;

public class Professor extends Teacher{
    public Professor(String name, int age,  double salary) {
        super(name, age,  salary);
        setPost("教授");
        setGrade(1.3);
    }

    @Override
    public void introduce() {
        super.introduce();
    }
}
