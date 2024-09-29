package com.edu.set_;

import java.util.HashSet;
import java.util.Objects;

/**
 * HashSet 数组扩容和红黑树机制
 * 1.底层是HashMap,第一次添加时,table数组扩容到16,临界值0.75*16
 * 2.到达临界值就再次扩容,按2倍扩容 (map.size与临界值比较,而非table数组大小)
 * 3.java8 中,如果一条链表元素个数超过8,且table大小 超过64,就树化,否则仍然数组扩容
 */
@SuppressWarnings({"all"})
public class HashSetIncrement {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
//        hashSet.add(null);
//        for (int i = 0; i < 100; i++) {
//            hashSet.add(i); // 每到临界值 扩容2倍, 16-32-64-128-...
//        }
//        hashSet.add(null); //
//        for (int i = 0; i < 15; i++) {
//            hashSet.add(new AA(i));
//        }
//        hashSet.add(new AA(8));
        // 链表超过8,但是table < 64 的情况下,不会树化,而是数组扩容,链表继续挂载
        // 这种情况下,每次链表超过8 的挂载 ,都导致数组都继续扩容,一直到数组超过64就开始树化
        // 树化后 结点Node -> TreeNode

        for (int i = 0; i < 8; i++) {
            hashSet.add(i);
        }
        for (int i = 0; i < 5; i++) {
            hashSet.add(new AA(i)); // table 数组元素个数 <= 12 ,但是 map.size (HashMap全部元素个数)超过了临界值,也会扩容
        }
        System.out.println(hashSet);
    }
}
class AA {
    private int num;

    public AA(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AA aa = (AA) o;
        return num == aa.num;
    }

    @Override
    public int hashCode() {
        return 100; // 保证每个对象的hash值都相同
    }
}
