package com.edu.homework;

public class Homework01 {
    public static void main(String[] args) {
//        try {
//            double res = cal(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
//            System.out.println(res);
//        } catch (NumberFormatException e) { // 数字格式不正确
//            System.out.println("参数不是整数");
//        } catch (ArrayIndexOutOfBoundsException e) { // 数组索引越界异常
//            System.out.println("参数不够2个");
//        } catch (ArithmeticException e) { // 算数异常
//            System.out.println("除数为0");
//        }
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            double res = cal(n1, n2); // 可能抛出算数异常
            System.out.println("计算结果是 " + res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("参数格式不正确,需要输入整数");
        } catch (ArithmeticException e) {
            System.out.println("出现除0的异常");
        }
    }

    // 方法,两数相除
    public static double cal(int n1, int n2) {
        return n1 / n2;
    }
}
