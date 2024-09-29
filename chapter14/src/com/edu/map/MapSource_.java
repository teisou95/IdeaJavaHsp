package com.edu.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 */
@SuppressWarnings({"all"})
public class MapSource_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("NO1","king");
        map.put("NO2","张三");
        map.put(new Car(),new Person());
        // 1.k-v 存储在 HashMap$Node 对象中
        /*
        Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
            return new Node<>(hash, key, value, next);
        }
         */
        // 2.k-v为了方便遍历,还会创建 EntrySet 集合,该集合存放的元素类型 Entry
        //      一个Entry对象就包含了k,v. EntrySet<Entry<K,V>>,即 transient Set<Map.Entry<K,V>> entrySet;
        // 3.entrySet 中,定义的类型是 Map.Entry,但是实际存放的还是 HashMap$Node
        //      这是因为  static class Node<K,V> implements Map.Entry<K,V>
        // 4.当把 HashMap$Node 对象存放到 entrySet 就方便遍历了,因为 Map.Entry 提供了重要的方法 getKey getValue
        Set set = map.entrySet();
        System.out.println(set.getClass()); // class java.util.HashMap$EntrySet
        for (Object obj :set) {
//            System.out.println(obj.getClass()); // class java.util.HashMap$Node
            // 为了取出 key 和 value ,先向下转型 为 Map.Entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println("key = " + entry.getKey());
            System.out.println("value = " + entry.getValue());
        }

        // 通过keyset拿到HashMap 的key
        Set keySet = map.keySet(); // 把 Node 的key值封装起来到 Set集合中
        for (Object o :keySet) {
            System.out.println(o);
        }
        // 通过 values 拿到 HashMap 的 value
        Collection values = map.values(); // value 封装到 Collection 集合
        for (Object o :values) {
            System.out.println(o);
        }


    }
}
class Car {

}
class Person {

}
