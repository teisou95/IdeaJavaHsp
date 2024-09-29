package com.edu.innerclass;

public class InnerClassExercise03 {
    public static void main(String[] args) {
        Test t = new Test(); // s1.a = 10; s2.a = 5
        Test.Inner r = t.new Inner();
        System.out.println("r.a = " + r.a); // r.a = 5
    }
}

class Test {
    public Test() {
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        System.out.println("s2.a = " + s2.a);
    }
    class Inner { // 成员内部类
        public int a = 5;
    }
}