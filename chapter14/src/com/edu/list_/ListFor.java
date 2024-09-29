package com.edu.list_;

import java.util.*;

/**
 * List 的 三种遍历方式
 * Vector LinedList ArrayList 实现子类都可以采用
 */
public class ListFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new Vector();
        list.add("jack");
        list.add("tom");
        list.add("鱼香肉丝");
        list.add(100);

        System.out.println("迭代器================");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        System.out.println("增强for==============");
        for (Object obj :list) {
            System.out.println(obj);
        }

        System.out.println("普通for================");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
