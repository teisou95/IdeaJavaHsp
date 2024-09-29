package com.edu.enumeration_;

import java.util.Enumeration;

/**
 * @author TeiSou
 * @version 1.0
 */
public class EnumerationExercise01 {
    public static void main(String[] args) {
        Gender02 boy = Gender02.BOY;
        Gender02 boy2 = Gender02.BOY;
        System.out.println("boy = " + boy); // 调用父类 Enum 的 toString 方法
        System.out.println("(boy == boy2) = " + (boy == boy2)); // T
        System.out.println("boy.name() = " + boy.name());
    }
}
enum Gender02 {
    BOY,
    GIRl;

//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
