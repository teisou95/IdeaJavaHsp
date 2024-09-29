package com.edu.anotation_;

/**
 * 注解
 */
public class Deprecated_ {
    public static void main(String[] args) {
        A a = new A();
        a.hi();
    }
}
// @Deprecated 修饰,表示该元素已过时,不在推荐使用,但仍然可以使用,可以做版本升级过渡使用
// @Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
@Deprecated
class A {
    public int n1 = 10;
    @Deprecated
    public void hi() {

    }
}