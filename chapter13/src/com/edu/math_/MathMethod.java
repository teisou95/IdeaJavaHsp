package com.edu.math_;

/**
 * Math 类 大量 static 方法
 */
public class MathMethod {
    public static void main(String[] args) {
        // abs 绝对值
        System.out.println(Math.abs(-9));

        // pow 幂
        System.out.println(Math.pow(2,4));

        // ceil 向上取整
        System.out.println(Math.ceil(-3.25));

        // floor 向下取整
        System.out.println(Math.floor(-3.5));

        // round 四舍五入
        System.out.println(Math.round(-3.4));

        // sqrt 开平方
        System.out.println(Math.sqrt(81));

        // random [0,1) 随机小数
        for (int i = 0; i < 3; i++) {
            System.out.println(Math.random());
        }

        // [a,b] 随机整数
        int a = 2;
        int b = 7;
        for (int i = 0; i < 5; i++) {
            int res = (int)((b - a + 1) * Math.random() + a);
            System.out.println(res);
        }

        // min max
        System.out.println(Math.min(1,45));
        System.out.println(Math.max(3.5, -9));
    }
}
