package com.edu.codeblock_;

/**
 * 代码块
 * 加载类时隐式执行
 * 对构造器的补充
 * 代码块的调用优先于构造器
 */
public class CodeBlock01 {
    public static void main(String[] args) {
        new Movie("西游记",52);
        System.out.println("===================");
        new Movie("新西游记",520,"张三");
    }
}
class Movie {
    private String name;
    private double price = 10;
    private String director;

    {
        // 全部构造器中反复使用的语句,做成代码块
        // 先执行了代码块,后构造器内语句
        System.out.println("电影屏幕打开");
        System.out.println("广告开始了");
        System.out.println("电影正式开始");
    }
    // 重载三个构造器
    public Movie(String name, double price, String director) {
        System.out.println("三个参数的构造器");
        this.name = name;
        this.price = price;
        this.director = director;
    }

    public Movie(String name, double price) {
        System.out.println("两个参数的构造器");
        this.name = name;
        this.price = price;
    }

    public Movie(String name) {
        this.name = name;
    }

    {
        // 全部构造器中反复使用的语句,做成代码块
        // 先执行了代码块,后构造器内语句
        System.out.println("电影结束了");
    }
}
