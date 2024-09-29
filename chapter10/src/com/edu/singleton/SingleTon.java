package com.edu.singleton;

/**
 * 单例模式-饿汉式 --> 不存在线程安全问题
 * ==> 类加载,单例就被创建了,即使可能还没使用
 * 1.构造器私有化 => 防止用户直接new
 * 2.类的内部创建私有静态对象,new
 * 3.向外暴露一个静态的公共方法,返回私有对象
 * java.lang.Runtime 就是饿汉式单例模式
 *
 * 单例模式-懒汉式 --> 存在线程安全问题,同时被调用会创建多个对象,单例模式被破坏
 * ==> 未调用方法时,单例不会被创建,资源节约了
 * 1.构造器私有化 => 防止用户直接new
 * 2.类的内部创建私有静态对象 ==> 但是不 new
 * 3.向外暴露一个静态的公共方法,判定是否已存在对象,若不存在则 new ,并返回私有对象
 */
public class SingleTon {
    public static void main(String[] args) {

//        GirlFriend mary = GirlFriend.getInstance();
//        System.out.println(mary);
//        System.out.println(mary.hashCode());
//        // 多次调用也还是同一个对象
//        GirlFriend king = GirlFriend.getInstance();
//        System.out.println(king);
//        System.out.println(king.hashCode());
//
//        System.out.println(mary == king); // T
//        System.out.println(GirlFriend.getN1()); // 100

        System.out.println(Cat.getN2());
        Cat tom = Cat.getInstance();
        Cat tom1 = Cat.getInstance();
        System.out.println(tom == tom1); // T

    }
}

class GirlFriend { // 饿汉式 - 可能造成资源的浪费
    private String name;
    private static int n1 = 100;

    public static int getN1() {
        return n1;
    }

    private GirlFriend(String name) { // 构造器私有化
        System.out.println("私有构造器被调用了");
        this.name = name;
    }

    private static GirlFriend mary = new GirlFriend("mary"); // 类的内部创建对象

    public static GirlFriend getInstance() { // 向外暴露静态公共方法,返回对象,保证了只能有一个对象
        return mary;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Cat { // 懒汉式 - 调用才会创建对象
    private String name;
    private static int n2 = 200;

    public static int getN2() {
        return n2;
    }

    private Cat(String name) {
        System.out.println("私有构造器被调用");
        this.name = name;
    }
    public static Cat tom;

    public static Cat getInstance() {
        if (tom == null) {
            tom = new Cat("tom");
        }
//        tom = new Cat("tom"); // 如果不加判定,会创建多个不同的对象
        return tom;

    }
}