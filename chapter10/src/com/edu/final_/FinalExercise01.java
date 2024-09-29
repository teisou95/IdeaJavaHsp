package com.edu.final_;

/**
 * 计算圆面积
 * final 圆周率
 */
public class FinalExercise01 {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("半径" + circle.getRadius() + "的圆,面积是" + circle.area());
    }
}

class Circle {
    private double radius;
    private final static double PI = 3.14; // 定义时赋值

//    private final static double PI;
//    static { // 代码块中赋值
//        PI = 3.14;
//    }

//    private final double PI;

    public Circle(double radius) {
//        PI = 3.14; // 构造器中赋值(不能是static)
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double area() {
        return PI * radius * radius;
    }
}