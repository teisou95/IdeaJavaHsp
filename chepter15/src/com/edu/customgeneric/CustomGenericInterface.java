package com.edu.customgeneric;

public class CustomGenericInterface {
    public static void main(String[] args) {
        C c = new C();
    }

}

// 泛型接口
interface A<T,M> {
    void m1(T t,M m);
}

// 继承接口 指定类型(不指定默认 Object)
interface B extends A<String ,Integer>{
    void m2();
}
// 实现接口 指定类型(不指定默认 Object)
class C implements A<Float ,StringBuffer>{
    @Override
    public void m1(Float aFloat, StringBuffer stringBuffer) {
    }
}
class E implements A{

    @Override
    public void m1(Object o, Object o2) { // 默认类型

    }
}
class D implements B {


    @Override
    public void m1(String s, Integer integer) {

    }

    @Override
    public void m2() {

    }
}