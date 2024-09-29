package com.edu.innerclass;

/**
 * 内部类 属性 方法 构造器 代码块
 * 内部类可以直接访问私有属性,可以循环嵌套内部类
 * 如果 Inner 类是非静态的，你需要一个 Outer 类的实例来创建它的实例。
 * 如果 Inner 类是静态的，你可以直接通过外部类创建它的实例，无需外部类的实例。
 */
public class InnerClass01 { // 外部其他类
    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer.getName());
        Outer.Inner inner = outer.new Inner();
        System.out.println("outer.getName() = " + outer.getName());
        inner.hi();
        Outer.StaInner staInner = new Outer.StaInner();
        System.out.println("Outer.getName() = " + Outer.getName());
        System.out.println("outer.getName() = " + outer.getName());
    }
}
class Outer { // 外部类
    private static String name;

    public Outer() {
    }
    {
        System.out.println("代码块");
    }

    public static String getName() {
        return name;
    }

    class Inner { // 成员内部类
        public Inner() {
            name = "king"; // 内部类的方法 可以直接访问 外部类的 私有属性
        }
        public void hi(){
            System.out.println("hi");
        }
    }
    static class StaInner { // 静态内部类
        public StaInner() {
            name = "wang";
        }
    }
}

class other {

}
