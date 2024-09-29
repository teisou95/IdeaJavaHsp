package com.edu.interface_;

/**
 * 当子类继承了父类,就自动拥有了父类的功能
 * 如果子类需要扩展功能,可以通过实现接口的机制扩展
 * 实现接口是对 java 单继承机制的补充
 * 接口可以实现代码解耦(接口规范性 + 动态绑定)
 */
public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey king = new LittleMonkey("king");
        king.climbing();
        king.swimming();
        king.fly();
    }
}

class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void climbing() {
        System.out.println(name + " 猴子会爬树");
    }
}

interface Fishable {
    void swimming();
}
interface Birdable {
    void fly();
}
class LittleMonkey extends Monkey implements Fishable, Birdable {
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + " 猴子学会了游泳");
    }


    @Override
    public void fly() {
        System.out.println(getName() + " 猴子学会了飞翔");
    }
}