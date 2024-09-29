package com.edu.map;

import java.util.Hashtable;
import java.util.Set;

/**
 * Hashtable 线程安全 HashMap线程不安全
 * Hashtable 的 key 和 value 都不能为 null
 */
@SuppressWarnings({"all"})
public class HashTableExercise {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("john",100);
//        hashtable.put(null,100);
//        hashtable.put("john",null);
        hashtable.put("lucy",100);
        hashtable.put("lic",100);
        hashtable.put("lic",88);
        hashtable.put("hello1",1);
        hashtable.put("hello2",1);
        hashtable.put("hello3",1);
        hashtable.put("hello4",1);
        hashtable.put("hello5",1);
        hashtable.put("hello6",1);

        Set keySet = hashtable.keySet();
        for (Object key :keySet) {
            System.out.print("key = " + key);
            System.out.println("\tvalue = " + hashtable.get(key));
        }

        // Hashtable 底层 有一个数组 Hashtable$Entry[] table 初始化length = 11
        // threshold 初始为 0.75 * 11 == 8
        // 第一次扩容到 23,threshold 变为 0.75 * 23 == 17
        // int newCapacity = (oldCapacity << 1) + 1;

    }
}
