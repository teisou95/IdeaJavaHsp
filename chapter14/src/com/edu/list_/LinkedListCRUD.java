package com.edu.list_;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * LinkedList 增删改查
 * LinkedList 增删效率高 改查效率低
 * ArrayList 增删效率低 改查效率高
 * 两者都线程不安全
 * Vector 线程安全 但效率低
 */
@SuppressWarnings({"all"})
public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        // add
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add("hello");
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);
        // 无参构造器 first = null last = null size = 0
        // add 方法 将实参设置为last 和 first, 且next = null, prev = oldLast ==> null
        // 将 新的结点加到双向链表的最后

        // remove(int index)
        // 找到 index 位置的结点(先判断在前半还是后半部分,再通过first.next 或last.prev 循环得到)
        // 目标结点prev item next 置null
        // 如果目标结点是first 或 last ,则重置 first 或last
        // 目标结点不是first 或last,将目标结点前后结点连接起来
        linkedList.remove(3);
        // remove() 默认删除第一个
        linkedList.remove();
        // remove(Object o)
        // 查找 目标结点
        // unlink(目标结点)
        linkedList.remove("hello");
        System.out.println(linkedList);

        // set 修改
        // 找到index 指向的结点
        // 目标结点.item 重新赋值
        // 返回原item
        linkedList.set(0, "真");

        // get
        // 检查index
        // 找到 目标结点
        // 返回 目标结点.item
        Object o = linkedList.get(1);
        System.out.println(o);

        // 遍历 for
        for (Object o1 : linkedList) {
            System.out.println(o1);
        }

        // for
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        // 迭代器
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
