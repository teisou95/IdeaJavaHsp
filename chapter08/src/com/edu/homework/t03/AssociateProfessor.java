package com.edu.homework.t03;

public class AssociateProfessor extends Teacher{
    public AssociateProfessor(String name, int age, double salary) {
        super(name, age, salary);
        setPost("副教授");
        setGrade(1.2);
    }

    @Override
    public void introduce() {
        super.introduce();
    }
}
