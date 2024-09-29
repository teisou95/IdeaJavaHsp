package com.edu.customgeneric;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<?> list1 = new ArrayList<Object>();
        List<Object> list2 = new ArrayList<Object>();

        list1.add(null);
        list2.add(null);

//        list1.add(new Object()); //コンパイルエラー
        list2.add(new Object());

//        list1.add(new Integer(1)); //コンパイルエラー
        list2.add(new Integer(1));


    }
}
