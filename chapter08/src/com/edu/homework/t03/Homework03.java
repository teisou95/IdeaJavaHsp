package com.edu.homework.t03;

public class Homework03 {
    public static void main(String[] args) {
        Teacher[] teachers = new Teacher[3];
        teachers[0] = new Professor("king", 35, 15000);
        teachers[1] = new AssociateProfessor("wang", 40, 15000);
        teachers[2] = new Lecturer("li", 66, 15000);
        for (int i = 0; i < teachers.length; i++) {
            teachers[i].introduce();
        }

    }
}
