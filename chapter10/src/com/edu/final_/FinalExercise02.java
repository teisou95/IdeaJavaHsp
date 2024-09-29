package com.edu.final_;

public class FinalExercise02 {
    public static void main(String[] args) {
        System.out.println(new Something().addOne(5));

    }
}

class Something {
    public int addOne(final int x) { // 形参可以加 final
//        ++x; // Cannot assign a value to final variable 'x'
        return x + 1;
    }

}