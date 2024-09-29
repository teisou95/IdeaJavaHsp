package com.edu.extend_;
// 0293

import java.util.Scanner;

public class ExtendsDetail {
    public static void main(String[] args) {
        // 子类必须调用父类的构造器,完成父类的初始化
        /*
            如果父类没有无参构造器,必须用 super()指定构造器完成父类的初始化
         */
        Sub sub = new Sub("123"); // 父类的构造器先被调用了
//        Sub sub1 = new Sub();
        sub.sayOk();
    }
}
