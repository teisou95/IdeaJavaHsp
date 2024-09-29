package com.edu.final_;

/**
 * final 类中,没必要写 final 方法
 * final 不能修饰构造器
 * final static 往往搭配使用,效率更高,不会导致类加载
 * 包装类 Integer String Double Float Boolean 都是 final 类
 */
public class FinalDetail02 {
    public static void main(String[] args) {
        System.out.println(BBB.NUM); // 类不加载
    }
}
class BBB {
    public final static int NUM = 30;
    static {
        System.out.println("BBB 静态代码块");
    }
}
class AAA {
//    public final AAA() { //Modifier 'final' not allowed here
//    }
}
