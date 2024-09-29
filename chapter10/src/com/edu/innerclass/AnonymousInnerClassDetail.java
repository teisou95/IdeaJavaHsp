package com.edu.innerclass;

/**
 * 调用匿名内部类
 */
public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
        System.out.println("outer05.hashCode() = " + outer05.hashCode());
    }
}
class Outer05 {
    private int n1 = 99;
    public void f1() {
        // 创建一个基于类的匿名内部类
        new Person() {
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了 hi 方法");;
            }

            @Override
            public void ok(String str) {
                super.ok(str);
            }
        }.ok("jack"); // 第一种调用方法

        Person person = new Person() {
            private int n1 = 200;
            @Override
            public void hi() {
                System.out.println("第二种匿名内部类调用方法");;
                System.out.println("n1 = " + n1); // 内外重名 就近原则
                System.out.println("Outer05.this.n1 = " + Outer05.this.n1); // 直接访问外部类的所有成员
                System.out.println("Outer05.this.hashCode() = " + Outer05.this.hashCode());
            }
        };
        person.hi();
    }
}
class Person {
    public void hi() {
        System.out.println("Person hi()");
    }
    public void ok(String str) {
        System.out.println("str = " + str);
    }
}