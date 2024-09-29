package com.edu.map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * TreeMap 和 TreeSet 一样,只不过 TreeSet的value是固定值 PRESENT = new Object()
 * key 不能调用compareTo后返回0(代表相同),如果key重复,会替换 value
 * 只能传入一种类型(或继承关系也可以),否则 会抛类型转换异常(比较的时候会循环 类型转换比较)
 * 无参构造器put 会调用该类型 默认 compare
 * 可以使用有参构造器 传入 new Comparator 接口匿名内部类 重写 compareTo 指定排序规则
 * key 不能为 null
 */
@SuppressWarnings({"all"})
public class TreeMap_ {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1; // key
                Integer i2 = (Integer) o2; // t.key
                return i1 + 2 - i2; // 指定排序规则 神奇的现象
            }
        });
//        treeMap.put(null,"kk"); // 空指针异常
        treeMap.put(1,"jack");
        treeMap.put(2,"tom");
        treeMap.put(3,"mary");// 默认排序, 从 root 开始,逐个比较
        treeMap.put(4,"tom");
        treeMap.put(3,"jack"); // key compareTo =>true 替换 value ,返回oldValue
        System.out.println(treeMap);

        TreeMap treeMap1 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        treeMap1.put("jack",1); // value 被替换了
        treeMap1.put("tom",2);
        treeMap1.put("simith",3);
        treeMap1.put("a",4);
        treeMap1.put("mary",100); // 认为和 jack 相同,key保持原key不变,替换 value
        System.out.println(treeMap1);
    }
}
