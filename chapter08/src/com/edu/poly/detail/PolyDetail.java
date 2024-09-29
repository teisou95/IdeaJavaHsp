package com.edu.poly.detail;

/**
 * 编译类型 与 运行类型
 * 向上转型
 * 向下转型
 * instanceof
 */
public class  PolyDetail {
    public static void main(String[] args) {
        Animal animal = new Cat(); // 向上转型,编译类型Animal, 运行类型Cat
        System.out.println(animal.age); // 10
        // 属性没有重写!属性的值直接看编译类型
        System.out.println(((Cat) animal).age); // 20

//        instanceof 判断对象的运行类型(实际对象的类型)是否为目标类型或目标类型的子类型
        System.out.println(animal instanceof Animal); // true
        System.out.println(animal instanceof Cat); // true

        Animal animal1 = new Animal();
        System.out.println(animal1 instanceof Cat); // false

        animal.eat(); // 猫吃鱼
        animal.sleep(); // 可以调用父类所有成员(要遵守访问权限)
//        animal.color;
//        animal.catchMouse();
        // 在编译阶段能调用哪些成员是由编译类型决定
        // 因此不能使用子类特有的成员

        // 向下转型只能强转父类的引用,不能强转父类的对象
        // 父类引用指向必须是目标子类对象
        // 强转后可以调用子类所有成员
        Cat cat = (Cat)animal;
        ((Cat) animal).catchMouse();
        cat.catchMouse();
        System.out.println(cat.color);
        new Cat().catchMouse();
    }
}