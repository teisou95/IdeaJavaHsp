package com.edu.set_;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * HashSet 底层是 HashMap => 底层是(数组+链表+红黑树)
 */
public class HashSetStructure {
    public static void main(String[] args) {
        // 模拟一个 HashMap 的底层
//        HashMap hashMap = new HashMap();

        // 创建一个数组 Node[] table,也称为 表
        Node[] table = new Node[16];

        Node john = new Node("john", null);
        table[2] = john;

        Node jack = new Node("jack", null);
        john.next = jack;
        // 将 jack 结点 挂载 到 john 后面
        // 形成链表

        Node rose = new Node("Rose", null);
        jack.next = rose; // 挂载进链表

        Node lucy = new Node("lucy", null);
        table[3] = lucy;


        for (Object o :table) {
            System.out.println(o);
        }

    }
}
// 结点 存放数据,可以指向下一个结点,形成链表
class Node {
    Object item; // 存放数据
    Node next; // 指向下一个结点

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
}
