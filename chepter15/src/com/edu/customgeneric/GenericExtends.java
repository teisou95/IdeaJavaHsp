package com.edu.customgeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * 0565
 * 泛型不具有继承性
 * <? extends T> 上限为 T,没有下限,编译器不知道具体是什么类型,赋值后不能添加元素,除了null
 * <? super T> 下限为 T,上限为 Object ,编译器不知道具体是什么类型,get方法丢失类型信息,必须声明编译类型为 Object
 * add 按下限添加
 * get 按上限取出
 */
public class GenericExtends {
    public static void main(String[] args) {
//        ArrayList<Object> strings = new ArrayList<String >();
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String > list2 = new ArrayList<>();
        ArrayList<AA> list3 = new ArrayList<>();
        ArrayList<BB> list4 = new ArrayList<>();
        ArrayList<CC> list5 = new ArrayList<>();

        List<?> list = list1;
        list.add(null);
        List<? extends AA> list100 = list4;
//        list.add(1); // 不能添加任何类型的元素,除了null
        List<? super BB> list0 = list3;
        list0.add(new CC());
        Object object = list0.get(0); //丢失泛型
        printCollection1(list5); // 1-5 ok
        printCollection2(list5); // 4-5 ok
        printCollection3(list4); // 1,3,4 ok

    }
    public static void printCollection1(List<?> c) { // 等价于 List<? extends Object>,上限是Object
        for (Object o :c) {
            System.out.println(o);
        }
    }
    public static void printCollection2(List<? extends BB> c){ //上限是AA
        for (Object o :c) {
            System.out.println(c);
        }
    }
    public static void printCollection3(List<? super BB> c) { // 下限是AA
        for (Object o :c) {
            System.out.println(c);
        }

    }
}
class AA{}
class BB extends AA{}
class CC extends BB{}