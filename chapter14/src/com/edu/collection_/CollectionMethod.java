package com.edu.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressWarnings("all")
public class CollectionMethod {
    public static void main(String[] args) {
        List list = new ArrayList(); // List 接口 接收 实现子类 ArrayList 的对象
        list.add("jack"); // 添加元素(Object对象)
        list.add(10);
        list.add(true);
        System.out.println("list = " + list); // [jack, 10, true]
//        Object remove = list.remove(0); // 返回被删除的对象
//        System.out.println(remove);
        list.remove(true); // 直接删除元素 返回 boolean 值
        System.out.println("list = " + list);

        boolean contains = list.contains(10); // 查找元素是否存在
        System.out.println(contains);

        System.out.println(list.size()); // 返回元素个数

        System.out.println(list.isEmpty()); // 判断是否为空

//        list.clear(); // 清空
//        System.out.println(list);

        ArrayList list2 = new ArrayList();
        list2.add("三国演义");
        list2.add("红楼梦");
        list.addAll(list2); // 添加一个 Collection 对象
        System.out.println(list);

        list.remove("三国演义");
        list.add("三国演义");
        System.out.println(list);
        System.out.println(list2);
        System.out.println(list.containsAll(list2)); // 查找多个元素是否存在,不要求顺序

        list.removeAll(list2); // 删除多个元素
        System.out.println(list);

        Iterator iterator = list.iterator(); // 返回一个迭代器
        while (iterator.hasNext()) { // 是否有更多元素
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
