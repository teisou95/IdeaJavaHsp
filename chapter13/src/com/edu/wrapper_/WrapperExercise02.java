package com.edu.wrapper_;

public class WrapperExercise02 {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // false

        Integer m = 1; // valueOf
        Integer n = 1;
        System.out.println(m == n); // true
        //  -128 to 127 之类的Integer 自动装箱,不会 new 新对象
        /*
            public static Integer valueOf(int i) {
                if (i >= IntegerCache.low && i <= IntegerCache.high)
                    return IntegerCache.cache[i + (-IntegerCache.low)];
                return new Integer(i);
            }
         */

        // -128 to 127 范围外,new 新对象
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y); // false
    }
}
