package com.edu.map;

import java.util.HashMap;

/**
 * HashMap 源码
 */
@SuppressWarnings({"all"})
public class HashMapSource {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("java", 10);
        hashMap.put("php", 10);
        hashMap.put("java", 20); // 替换value, modCount 替换时不增加
        System.out.println("hashMap = " + hashMap);

        // 源码:
        /*
        1.执行构造器,初始化 this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
                HashMap$Node[] table = null
        2.执行put(k,v)
            public V put(K key, V value) { // key:"java" value:10
                return putVal(hash(key), key, value, false, true);
            }
        3.执行hash(key) 得到 hash值(不是hashCode)
            static final int hash(Object key) {
                int h;
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            }
        4.执行putVal
            final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                       boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i;
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length; // 扩容
                if ((p = tab[i = (n - 1) & hash]) == null) // 得到hash对应的table索引位置的结点
                    tab[i] = newNode(hash, key, value, null); // 如果为null 直接创建 新Node 挂载
                else {
                    Node<K,V> e; K k;
                    // 如果当前Node 的 key 与要加入的 key 相同(hash相同 且 (同一对象 或 equals返回true))
                    // 就不能添加新的 k-v
                    if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;
                    else if (p instanceof TreeNode) // 如果是树
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                    else { // 如果是链表,且与链表第一个 key 相同 // 循环对比链表后面的Node 的 key
                        for (int binCount = 0; ; ++binCount) {
                            if ((e = p.next) == null) { // 比较到链表最后了
                                p.next = newNode(hash, key, value, null); // 挂载 新Node
                                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                    treeifyBin(tab, hash); // 是否要树化
                                break;
                            }
                            // 如果发现与某一个Node 的 key 相同
                            // 就不添加,而是替换
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            p = e;
                        }
                    }
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value; // 替换value
                        afterNodeAccess(e);
                        return oldValue; // 返回旧value
                    }
                }
                ++modCount; // 每增加一个 Node ,modCount++(替换不++)
                if (++size > threshold)
                    resize();
                afterNodeInsertion(evict);
                return null;
            }

         */
    }
}
