package com.edu.innerclass;

/**
 * 静态内部类
 * 定义在外部类成员位置, static
 */
public class StaticInnerClass01 {
    public static void main(String[] args) {
        new Outer07.Inner07().hello(); // 静态内部类可以在外部其他类直接创建,不需要 外部类对象
        new Outer07().m1();
        new Outer07().getInner07Instance().hello();
        Outer07.staticGetInner07Instance().hello();
    }
}

class Outer07 {
    private static int n1 = 100;
    private String name;

    // 可以添加任意访问修饰符
    protected static class Inner07 { // 静态内部类
        private int n1 = 200;
        public void hello() {
            System.out.println("n1 = " + n1); // 就近原则
            // 因为访问的是静态成员,所以不需要 this
            System.out.println("Outer07.n1 = " + Outer07.n1); // 可以直接访问外部类的所有静态成员
        }
    }
    public void m1() {
        new Inner07().hello();
    }
    public Inner07 getInner07Instance() {
        return new Inner07();
    }
    public static Inner07 staticGetInner07Instance() {
        return new Inner07();
    }
}
