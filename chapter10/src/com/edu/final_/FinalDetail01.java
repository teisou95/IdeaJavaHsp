package com.edu.final_;

/**
 * final 属性 命名,全大写,单词用 _ 连接 ,如 TAX_RATE
 * 定义时就必须初始化,之后不能被修改(也可以在构造器或代码块中 初始化)
 *
 * 如果是 static final 属性,只能在 定义时 或 static 代码块中 初始化,不能在 构造器中
 */
public class FinalDetail01 {
    public static void main(String[] args) {
        AA aa = new AA();
        System.out.println(aa.getGender());
        new CC();

        new EE().cal(); // 可以调用到 继承自 父类的 final 方法

    }
}

class AA {
    private final int MONTHS = 12; // 定义时就初始化
    private final double RATE;
    private final char gender;

    public AA() { // 构造器中初始化
        this.RATE = 0.03;
    }
    {
        gender = '男'; // 代码块中初始化
    }

    public char getGender() {
        return gender;
    }
}

class BB {
    private static final String name1 = "king"; // 定义时
    private static final String name2; // 静态代码块中
//    private static final String name3; // 不能在构造器中 Variable 'name3' might not have been initialized
    static {
        name2 = "wang";
    }

//    public BB() {
//        name3 = "mary";
//    }
}

// final 类可以实例化,只是不能继承
final class CC {}

// 非 final 类中 的final 方法,可以被继承,只是不能重写
class DD {
    public final void cal() {
        System.out.println("cal方法");
    }
}

class EE extends DD {

}