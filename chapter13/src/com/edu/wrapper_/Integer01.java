package com.edu.wrapper_;

/**
 * Integer - int 转换
 * 装箱:基本数据类型 -> 包装类
 * 拆箱:包装类 -> 基本数据类型
 * 自动装箱:valueOf 方法
 */
public class Integer01 {
    public static void main(String[] args) {
        // 手动装箱
        // int -> Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);

        // 手动拆箱
        // Integer -> int
        Integer integer2 = new Integer(200);
        int n2 = integer2.intValue();

        // jdk5 之后自动装箱和自动拆箱
        int n3 = 300;
        Integer integer3 = n3; // 底层调用了 Integer.valueOf(n3)
        /*
            public static Integer valueOf(int i) {
                if (i >= IntegerCache.low && i <= IntegerCache.high)
                    return IntegerCache.cache[i + (-IntegerCache.low)];
                return new Integer(i);
            }
         */
        int n4 = integer3; // 底层调用 integer3.intValue() 方法


    }
}
