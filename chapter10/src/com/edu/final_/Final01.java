package com.edu.final_;
/**
 * final 关键字
 * 修饰 类 方法 属性 局部属性
 */
public class Final01 {
    public static void main(String[] args) {
//        new E().TAX_RATE = 0.10; // Cannot assign a value to final variable 'TAX_RATE
    }
}

// 不希望被其他类继承,加 final
final class A {

}

//class B extends A { } // Cannot inherit from final 'com.edu.final_.A'

class C{
    public final void hi() { // 不希望被子类重写,加 final

    }
}
class D extends C{
//    @Override
//    public void hi() { //'hi()' cannot override 'hi()' in 'com.edu.final_.C'; overridden method is final
//        super.hi();
//    }

}

class E {
    public final double TAX_RATE = 0.08; //不希望属性被修改,加 final,变为常量,用大写字母命名
}

class F {
    public void cry() {
        // 不希望局部属性被修改,加 final ,变为局部常量
        final double NUM = 0.01;
//        NUM = 0.9; // Cannot assign a value to final variable 'NUM'
        System.out.println(NUM);
    }
}