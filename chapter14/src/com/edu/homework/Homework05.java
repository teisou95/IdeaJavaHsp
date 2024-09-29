package com.edu.homework;



import java.util.Comparator;
import java.util.TreeSet;
@SuppressWarnings({"all"})
public class Homework05 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person()); // 没有传入比较器的TreeMap add 的对象必须 实现 Comparable 接口

        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });
        set.add(new Cat()); // // 传入了比较器的TreeMap add 的对象不需要 实现 Comparable 接口
    }

}

class Person implements Comparable{

    @Override
    public int compareTo(Object o) {
        return hashCode() - o.hashCode();
    }
}

class Cat {

}