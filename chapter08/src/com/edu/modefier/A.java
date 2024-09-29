package com.edu.modefier;

public class A {
    // 四个属性,分别使用不同的访问修饰符
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public void m1() {
        // 同类,该方法可以访问全部四个属性
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        System.out.println("n3 = " + n3);
        System.out.println("n4 = " + n4);

    }

    protected void m2() {
    }

    void m3() {
    }

    private void m4() {

    }

    public void hi() {
        // 同类全部可以调用
        m1();
        m2();
        m3();
        m4();
    }
}
