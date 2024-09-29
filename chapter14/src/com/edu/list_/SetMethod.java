package com.edu.list_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

// set 接口
// 主要的实现类 TreeSet HashSet
// 无序 没有索引
// 不允许重复元素,最多只能有一个null
@SuppressWarnings({"all"})
public class SetMethod {
    public static void main(String[] args) {
//        Set treeSet = new TreeSet();
        Set hashSet = new HashSet();
        hashSet.add("john");
        hashSet.add("lucy");
        hashSet.add("john"); // 不报错
        hashSet.add("jack");
        hashSet.add(null);
        hashSet.add(52);
        hashSet.add(null); // 不报错
        hashSet.clear();
        for (int i = 0; i < 10; i++) {
            hashSet.add(i * (10-i));
        }
//        System.out.println(hashSet.toString()); // [null, licy, john, jack]
        for (int i = 0; i < 10; i++) {
            System.out.println(hashSet);
        }
        // 添加顺序与取出顺序不一致,重复添加不起作用
        // 取出顺序是固定的,有自己的底层排序算法

        // 遍历 迭代器
        System.out.println("==============");
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        // for
        System.out.println("+===========");
        for (Object o:
             hashSet) {
            System.out.println(o);
        }
         // 不能通过索引获取,普通for 不行

        // remove
        hashSet.remove(9);
        System.out.println(hashSet);
    }
}
