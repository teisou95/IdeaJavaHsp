package com.edu.set_;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * LinkedHashSet 底层是 LinkedHashMap -> HashMap的子类
 * 不允许重复挂载
 * 底层维护了一个 数组(第一次扩容到16) + 双向链表 + 单向链表
 * 按 table数组索引位置形成单向链表
 * 按结点加入顺序形成双向链表 节点类型不是 Node ,是LinkedHashMap$Entry => 存储到 HashMap$Node[]
 * 通过双向链表 使 加入顺序 与取出顺序 一致
 */
@SuppressWarnings({"all"})
public class LinkedHashSet_ {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new String("AA"));
        linkedHashSet.add(456);
        linkedHashSet.add(456);
        linkedHashSet.add(new Customer("刘",1001));
        linkedHashSet.add("KING");
        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        for (int i = 0; i < 1000; i++) {
            linkedHashSet.add(i); // 父类 HashSet 的单向链表 还是有的
        }
    }
}

class Customer {
    private String name;
    private int num;

    public Customer(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return num == customer.num &&
                Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, num);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}