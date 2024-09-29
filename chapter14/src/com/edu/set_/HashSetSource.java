package com.edu.set_;

import java.util.HashSet;

/**
 * 0522
 * HashSet add() 时的 底层实现
 * hash() + equals()
 *
 * 1.HashSet 底层是 HashMap
 * 2.add() 先得到 hash值 =>转为 索引值
 * 3.找到存储数据表 table ,确认索引是否有值
 * 4.如果没有,直接加入
 * 5.如果有,调用 equals 与 链表已有元素 逐个比较,如果相同,放弃添加,如果都不同,就添加到链表最后
 * 6.java8 中,一条链表的元素个数到达 默认8 ,并且 table 的大小到达 默认64 就会树化(红黑树)
 */
@SuppressWarnings({"all"})
public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
//        for (int i = 0; i < 15; i++) {
//            if (i == 3) {
//                hashSet.add("java");
//                continue;
//            }
//            hashSet.add(i);
//        }
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
//        int h = "哈哈哈哈哈哈哈".hashCode(); // hashCode 算法 循环计算 int h = h * 31 + val[i]
//        int n = 31 * 1200001111; // 超过上限,负数
//        int i = h >>> 16; // 逻辑右移16位
//        int hash = h ^ i; // 按位异或
        System.out.println(hashSet);
        // 第一次 add 源码解读
        /*
            1.执行 构造器 HashSet(),调用 HashMap 创建新 HashSet 对象
                public HashSet() {
                    map = new HashMap<>();
                }
            2.执行 add()
                public boolean add(E e) { // e:"java"
                    return map.put(e, PRESENT)==null;
                }
            3.执行 HashMap 的 put()
                public V put(K key, V value) { // key:"java" value:PRESENT(final static PRESENT = new Object())
                    return putVal(hash(key), key, value, false, true);
                }
            4.执行 hash(key),得到 key 对应的hash值(并不等于hashCode)
                static final int hash(Object key) { // key: "java"
                    int h;
                    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); // 为了避免与hashCode完全相同
                }
            5.执行 putVal
                final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                       boolean evict) { // hash(key) key:"java" value:PRESENT //定义辅助变量
                    Node<K,V>[] tab; Node<K,V> p; int n, i;
                    // if 如果当前table是null或者大小为0
                    // 就是第一次扩容,到16
                    if ((tab = table) == null || (n = tab.length) == 0) // table:HashMap 的数组,类型是 Node[]
                        n = (tab = resize()).length; // resize()返回容量16的newTab,并且table容量也置为了16, n = 16
                        // i = (n - 1) & hash :计算出来的索引,tab[index] -> p
                    if ((p = tab[i = (n - 1) & hash]) == null) // 计算key的索引值,判断目标位置是否为空
                        tab[i] = newNode(hash, key, value, null); // 创建 Node -> tab[i]
                    else {
                        Node<K,V> e; K k; // 局部变量 哪里需要 哪里创建
                        if (p.hash == hash && // hash相同且 是同一个对象(或equals为true)
                            ((k = p.key) == key || (key != null && key.equals(k))))
                            e = p;
                        else if (p instanceof TreeNode) //红黑树
                            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                        else { // 与链表结点逐个比较
                            for (int binCount = 0; ; ++binCount) {
                                if ((e = p.next) == null) { // 到链表最后位置了
                                    p.next = newNode(hash, key, value, null); // 挂载新元素到该链表最后
                                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st // 如果链表达到长度8
                                        treeifyBin(tab, hash); // 对当前链表树化(内部判断table大小 >= 64 才真正树化)
                                    break; // 挂载完成,跳出循环
                                }
                                if (e.hash == hash &&
                                    ((k = e.key) == key || (key != null && key.equals(k))))
                                    break; // 发现有一个相同,就不挂载了,跳出循环
                                p = e; // p后移到 p.next
                            }
                        }
                        if (e != null) { // existing mapping for key
                            V oldValue = e.value;
                            if (!onlyIfAbsent || oldValue == null)
                                e.value = value;
                            afterNodeAccess(e);
                            return oldValue;
                        }
                    }
                    ++modCount;
                    if (++size > threshold) // new size 是否大于 限值
                        resize();
                    afterNodeInsertion(evict); // 空方法
                    return null; // 成功挂载
                }
         */


    }
}
