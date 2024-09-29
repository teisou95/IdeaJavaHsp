package com.edu.innerclass;

/**
 * 局部内部类:
 * 定义在外部类的局部位置,如方法体中,并且有类名
 */
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
        System.out.println("outer02.hashCode() = " + outer02.hashCode());


    }
}

class Outer02 { // 外部类
    private int n1 = 100;

    private void m2() { // 私有方法
        System.out.println("Outer02 m2方法");
    }
    public void m1() { // 方法
        // 不能添加访问修饰符,但是可以 + final
        // 相当于局部变量,作用域只在定义的方法体或代码块中
        class Inner02 { // 局部内部类
            private int n1 = 800; // 重名
            // 可以直接访问外部类所有成员,包括私有
            public void f1() {
                System.out.println("n1 = " + n1); // 就近原则
                // Outer02.this 就是外部类的对象,指向调用 m1 的外部类对象
                System.out.println("Outer02.this.n1 = " + Outer02.this.n1);
                System.out.println("Outer02.this.hashCode() = " + Outer02.this.hashCode());
                m2();
            }
        }

        class Inner03 extends Inner02 {

        }

        // 作用域内可以创建内部类对象,调用方法
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
    { // 代码块
        class Inner04 {

        }
    }
}
