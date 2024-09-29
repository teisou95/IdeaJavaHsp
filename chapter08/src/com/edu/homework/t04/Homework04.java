package com.edu.homework.t04;

public class Homework04 {
    public static void main(String[] args) {
        Staff wang = new Staff("wang", 500, 25);
        Master li = new Master("li", 1200, 21);
        li.setBonus(3000);

        wang.printSal();
        li.printSal();
    }
}
