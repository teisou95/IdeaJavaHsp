package com.edu.anotation_;

/**
 * 注解
 * @Override 只能用于方法,表示重写了父类的方法
 */
public class Override_ {
}
class Father {
    public void fly() {
        System.out.println("父类fly");
    }
}
class Son extends Father {
    // 如果写了注解,编译器会检查该方法是否真的构成重写
    @Override
    // public @interface Override {} 不是接口,是一个注解类
    // @Target(ElementType.METHOD)
    // @Target 是修饰注解的注解,元注解
    public void fly() {
        super.fly();
    }
//    @Override // Method does not override method from its superclass
//    public void say() {
//    }

}