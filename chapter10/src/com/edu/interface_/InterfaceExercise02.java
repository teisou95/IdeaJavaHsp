package com.edu.interface_;

public class InterfaceExercise02 {
    public static void main(String[] args) {
        new CX().pX();
    }
}
interface IX {
    int x = 0;
    void hi();
}
class BX {
    int x = 1;
    public void hi() { // 通过子类实现接口方法
        System.out.println("父类的hi");
    }
}
class CX extends BX implements IX {

    public void pX() {
        System.out.println("IX.x = " + IX.x);
        System.out.println("super.x = " + super.x);
    }
}
