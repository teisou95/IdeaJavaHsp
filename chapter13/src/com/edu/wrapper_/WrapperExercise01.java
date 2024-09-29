package com.edu.wrapper_;

public class WrapperExercise01 {
    public static void main(String[] args) {
        Double d = 100D;
        Float f = 1.5F;

        // 三元运算符作为一个整体,精度提高到Double 类型
        Object obj1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(obj1); // 1.0
        System.out.println(obj1.getClass()); // class java.lang.Double

        Object obj2;
        if (true)
            obj2 = new Integer(1);
        else
            obj2 = new Double(2.0);
        System.out.println(obj2); // 1
    }
}
