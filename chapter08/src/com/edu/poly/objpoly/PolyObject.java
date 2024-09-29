package com.edu.poly.objpoly;

/**
 * 对象的编译类型/运行类型区别,运行类型变化体现多态
 */
public class PolyObject {
    public static void main(String[] args) {
        Animal animal = new Cat(); // 编译类型 Animal, 运行类型 Cat
        animal.cry(); // Cat cry
        animal = new Dog(); // 运行类型改为 Dog
        animal.cry(); // Dog cry
        animal = new Animal(); // 运行类型改为 Animal
        animal.cry(); // Animal cry

    }
}
