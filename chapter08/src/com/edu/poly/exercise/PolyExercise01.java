package com.edu.poly.exercise;

/**
 * 多态-转型
 * 判断代码正误
 */
public class PolyExercise01 {
    public static void main(String[] args) {
        double d = 13.4;
        long l = (long) d; // T
        System.out.println(l);

        int in = 5;
//        boolean b = (boolean) in; // F

        Object obj = "Hello"; // 向上转型
        String objStr = (String) obj; // T 向下转型
        System.out.println(objStr);

        Object objPri = new Integer(5); // 向上转型
//        String str = (String) objPri; // F
        Integer Str1 = (Integer) objPri; // T // 向下转型
    }
}
