package com.edu.interface_;

/**
 * 接口的多态传递
 */
public class InterfacePolyPass {
    public static void main(String[] args) {
        IG ig = new Teacher();
        IH ih = new Teacher();
    }
}

interface IH {
    void hi();
}
interface IG extends IH{
    void hello();
}
// 类实现了接口,该接口所继承的接口也被实现了
class Teacher implements IG {

    @Override
    public void hi() {

    }

    @Override
    public void hello() {

    }
}