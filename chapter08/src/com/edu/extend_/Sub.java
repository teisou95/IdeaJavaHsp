package com.edu.extend_;

// 子类,继承 Base
// CTRL + H 可以看到类的继承关系
// CTRL + B 定位类和方法
// java.lang.Object 是所有类的父类
// 父类构造器的调用不限于直接父类,将一直追溯到顶级父类Object,从Object往下通过构造器进行初始化
// java是单继承机制,最多只能有一个直接父类
public class Sub extends Base {
    public Sub() {
        // super 必须在子类构造器第一行
        // super 只能在构造器中使用
        // 构造器中 super 和 this 都必须在第一行,所以不能共存
        super(1, 2, 3, 4); // 如果不写super,默认调用父类无参构造器对父类进行初始化
        System.out.println("子类的无参构造器 Sub()...");
    }

    /*
        如果父类没有无参构造器
        There is no default constructor available in 'com.edu.extend_.Base'
     */
    public Sub(String time) {
//        super();
        this();
        System.out.println("子类的有参构造器");
    }

    public void sayOk() {
        // 子类继承了所有的属性和方法,但是父类私有的属性和方法不能在子类直接访问,要通过公共方法访问
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        System.out.println("n3 = " + n3);
        System.out.println("getN4() = " + getN4());
        // n4 不能直接访问
        test100();
        test200();
        test300();
        // test400() 不能直接访问,'test400()' has private access in 'com.edu.extend_.Base'
        callTest400();
        // 通过父类提供的公共方法访问私有属性和私有方法


    }
}
