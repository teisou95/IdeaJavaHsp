package com.edu.bignumber;

import java.math.BigInteger;

// 大数整型
public class BigInteger_ {
    public static void main(String[] args) {
        long l = 2351654547405581L;
        System.out.println(l);

        // 比long 极限更大的数
        // BigInteger 类
        BigInteger bigInteger = new BigInteger("2351654547405999999999999");
        System.out.println(bigInteger);
        // 加减乘除
        BigInteger bigInteger1 = new BigInteger("9999999999");
        BigInteger add = bigInteger.add(bigInteger1);
        System.out.println(add);

        BigInteger subtract = bigInteger.subtract(bigInteger1);
        System.out.println(subtract);

        BigInteger multiply = bigInteger.multiply(bigInteger1);
        System.out.println(multiply);

        BigInteger divide = bigInteger.divide(bigInteger1);
        System.out.println(divide);
    }
}
