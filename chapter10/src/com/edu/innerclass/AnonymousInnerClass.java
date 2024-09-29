package com.edu.innerclass;

/**
 * 匿名内部类
 * 定义在外部类的局部位置,如方法体中,并且没有类名
 * 本质:类/内部类/匿名/同时还是一个对象
 * 本质:创建匿名 子类(或实现类)并返回对象实例
 * new 类/接口(形参列表) {};
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer03 outer03 = new Outer03();
        outer03.method();
    }
}

class Outer03 { // 外部类
    private int n1 = 100;

    public int getN1() {
        return n1;
    }

    public void method() {
        // 基于接口的匿名内部类
        // 1.需求:使用接口 IA ,并创建对象
        // 2.传统方法,写一个类,实现该接口,并创建对象
        // 3.需求:Tiger类只使用一次,不想定义一个类
        // 4.解决方案,匿名内部类
        // 5.tiger编译类型是接口类型IA,运行类型是匿名内部类 Outer03$1
        /*
            底层代码:
            class Outer03$1 implement IA {
                @Override
                public void cry() {
                    System.out.println("老虎叫");
                }
            }
            IA tiger = new Outer03$1();
         */
        // 7.new : jdk底层在创建匿名内部类 Outer03$1 之后,立即创建了实例并将地址返回给 tiger
        // 8.匿名内部类返回对象实例之后,就销毁了
//        IA tiger = new Tiger();
//        tiger.cry();
        IA tiger = new IA(){ // 创建了一个对象,编译类型是接口IA,实际是一个实现IA 的内部类,直接重写接口方法
            @Override
            public void cry() {
                System.out.println("老虎叫");
            }
        };
        tiger.cry();
        System.out.println("tiger 的运行类型 " + tiger.getClass()); // class com.edu.innerclass.Outer03$1

        IA cat = new IA() {
            @Override
            public void cry() {
                System.out.println("小猫叫");
            }
        };
        cat.cry();
        System.out.println("cat 的运行类型 " + cat.getClass()); // class com.edu.innerclass.Outer03$2
        Outer03 dog = new Outer03() {
        };
        Outer03 monkey = new Outer03();
        System.out.println("dog.getClass() = " + dog.getClass()); // class com.edu.innerclass.Outer03$3
        System.out.println("monkey.getClass() = " + monkey.getClass()); // class com.edu.innerclass.Outer03

        // 基于类的匿名内部类
        // 编译类型 Father,运行类型Outer03$4
        // 底层创建匿名内部类
        /*
            class Outer03$4 extends Father {
            ...
            }
            Father father = new Outer03$4();
         */
        Father father = new Father("jack"){ // 参数列表会传递给 父类 的构造器
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        father.test();
        System.out.println("father.getClass() = " + father.getClass()); // class com.edu.innerclass.Outer03$4

        // 基于抽象类的匿名内部类
        Animal animal = new Animal() {
            @Override
            void eat() {
                System.out.println("=================");
                System.out.println("吃吃吃");
            }
        };
        animal.eat();
    }

}
interface IA { // 接口
    public void cry(); // 抽象方法
}
//class Tiger implements IA {
//    @Override
//    public void cry() {
//        System.out.println("老虎叫");
//    }
//}
//class Dog implements IA {
//    @Override
//    public void cry() {
//
//    }
//}

class Father {
    private String name;
    public Father(String name) {
        this.name = name;
        System.out.println("父类构造器接收到 name = " + name);
    }
    public void test() {
    }
}
abstract class Animal {
    abstract void eat();
}