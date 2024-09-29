package com.edu.override_;

public class Dog extends Animal {
    // 子类Dog 的cry() 方法重写了父类 Animal 的 cry() 方法
    public void cry() {
        System.out.println("小狗汪汪");
    }

     public String m1(String jag) { // 构成重写
        return null;
    }
//    public Object m2(){ //
//        return null;
//    }
    // 'm2()' in 'com.edu.override_.Dog' clashes with 'm2()' in 'com.edu.override_.Animal';
    // attempting to use incompatible return type
}
