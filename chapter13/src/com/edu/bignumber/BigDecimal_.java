package com.edu.bignumber;

import java.math.BigDecimal;

// 大数浮点型
public class BigDecimal_ {
    public static void main(String[] args) {
        double d = 1.9999999999999999999999999D;
        System.out.println(d);

        // 需要保存精度很高的数
        BigDecimal bigDecimal = new BigDecimal("1.9999999999999999999999999999999999");
        System.out.println(bigDecimal);
        BigDecimal bigDecimal1 = new BigDecimal("0.25555555555555");

        // 加减乘除
        BigDecimal add = bigDecimal.add(bigDecimal1);
        System.out.println(add);

        BigDecimal subtract = bigDecimal.subtract(bigDecimal1);
        System.out.println(subtract);

        System.out.println(bigDecimal.multiply(bigDecimal1));

//        System.out.println(bigDecimal.divide(bigDecimal1)); // 可能抛出 除不尽异常
        // 指定精度 BigDecimal.ROUND_CEILING 保留到分子的精度
        System.out.println(bigDecimal.divide(bigDecimal1,BigDecimal.ROUND_CEILING));
    }
}
