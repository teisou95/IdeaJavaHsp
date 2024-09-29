package com.edu.interface_;

public class InterfaceExercise {
    public static void main(String[] args) {
        BBBB bbbb = new BBBB();
        System.out.println("bbbb.a = " + bbbb.a);
        System.out.println("AAAA.a = " + AAAA.a);
        System.out.println("BBBB.a = " + BBBB.a);
    }
}
interface AAAA {
    int a = 23; // 等价于 public static final int a = 23;
}
class BBBB implements AAAA { // 可以访问父类的属性和方法

}
