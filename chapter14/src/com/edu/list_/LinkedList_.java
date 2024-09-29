package com.edu.list_;

/**
 * LinkedList 底层实现了双向链表 和 双端队列的特点
 * 线程不安全
 * first 和 last 分别指向首结点和尾结点
 * 每个节点(Node对象),里面又维护了prev next item 三个属性,
 * 通过prev 指向前一个,通过next指向后一个,最终实现双向链表
 * LinkedList 的元素的添加和删除,不是通过数组实现,是通过改变 prev next 指向实现,效率较高
 */
public class LinkedList_ {
    public static void main(String[] args) {
        // 举例简单的双向链表
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node mary = new Node("玛丽");
        // 连接三个结点 形成双向链表
        jack.next = tom;
        tom.next = mary;
        mary.prev = tom;
        tom.prev = jack;
        // 链表首结点 尾结点 设置
        Node first = jack;
        Node last = mary;

        // 从头到尾遍历
//        Node currentNode = first;
//        while (currentNode != null) {
//            System.out.println(currentNode);
//            currentNode = currentNode.next;
//        }
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        first = jack;

        // 从尾到头遍历
        while (true) {
            if (last == null) {
                break;
            }
            System.out.println(last);
            last = last.prev;
        }
        last = mary;

        System.out.println("=============== ");
        // 链表添加对象/数据
        // jack tom hello mary
        Node hello = new Node("hello");
        // 修改链表前后指向
        tom.next = hello;
        hello.prev = tom;
        mary.prev = hello;
        hello.next = mary;
        // 从头到尾遍历
        Node currentNode = first;
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }

        // 删除对象
        // jack hello mary
        jack.next = jack.next.next;
        hello.prev = hello.prev.prev;

        System.out.println("================");
        // 从头到尾遍历
        currentNode = first;
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }

    }
}

// 双向链表的结点,Node 对象
class Node {
    public Object item; // 真正存放数据的地方
    public Node next; // 指向下一个结点
    public Node prev; // 指向上一个结点

    public Node(Object name) {
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node name = " + item;
    }

}
