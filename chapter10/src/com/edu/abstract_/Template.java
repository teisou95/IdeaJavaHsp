package com.edu.abstract_;

/**
 * 模板设计模式
 * 抽象方法 抽象类 实践
 * 在模板设计模式中，抽象方法是非常重要的，因为它定义了子类必须实现的行为，并且为算法提供了一个统一的结构。
 */
public class Template {
    public static void main(String[] args) {
        new Sup1().calTime();
        new Sup2().calTime();
        new Sup3().calTime();
    }
}

abstract class Temp {
    abstract public void job();
    public final void calTime() {
        long startTime = System.nanoTime();
        job();
        long endTime = System.nanoTime();
        System.out.println("耗时" + (endTime - startTime));
    }
}
class Sup1 extends Temp {
    @Override
    public void job() {
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            sum += i;
        }
        System.out.print("Sup1类");
    }
}
class Sup2 extends Temp {
    @Override
    public void job() {
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            sum += i;
        }
        System.out.print("Sup2");
    }
}

class Sup3 extends Temp {
    @Override
    public void job() {
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            sum += i;
        }
        System.out.print("Sup3");
    }
}