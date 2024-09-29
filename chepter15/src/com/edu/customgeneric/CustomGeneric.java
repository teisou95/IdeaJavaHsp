package com.edu.customgeneric;

public class CustomGeneric {
}

// 自定义泛型类
// 普通成员可以使用泛型(属性,方法)
// 使用泛型的数组,不能直接在泛型类中初始化
class Tiger<T,R,M> {
    String name;
    T t;
    R r;
    M m;
//    static R r2; // 静态成员不能使用泛型
//    public static void m1(M m) { }//Tiger.this' cannot be referenced from a static context
    public Tiger(String name, T t, R r, M m) {
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
        T[] ts; // 不初始化可以
//        T[] ts = new T[3]; // type parameter 'T' cannot be instantiated directly
        // 数组在 new 的时候不能确定 T 的类型,无法在内存开空间
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }
}
