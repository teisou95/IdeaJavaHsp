package com.edu.map;

import java.util.*;

/**
 * Map 接口 遍历方式
 * entrySet ->转型 Map.Entry,使用方法 getKey 和 getValue获取 k-v
 * keySet -> 直接获取 key,使用 get(index key) 获取 value
 * values -> 只能获取 value
 */
@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        // 添加 put(key,value)
        map.put("邓超","孙俪");
        map.put("王宝强","马蓉");
        map.put("宋喆","马蓉");
        map.put("刘宁波",null);
        map.put(null,"刘亦菲");
        map.put("鹿晗","关晓彤");

        System.out.println("===========entrySet 遍历 Node===============");
        System.out.println("===============增强for");
        for (Object key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
        System.out.println("=================迭代器");
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator1.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("============keySet遍历 key===================");
        System.out.println("===============增强 for:");
        for (Object key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
        System.out.println("===================迭代器:");
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + " = " + map.get(key));
        }
        System.out.println("============values遍历");
        System.out.println("增强 for:");
        for (Object value :map.values()) {
            System.out.println(value);
        }
        System.out.println("=============普通 for:");
        for (int i = 0; i < map.values().size(); i++) {
            System.out.println(map.values().toArray()[i]);
        }
        System.out.println("=============迭代器:");
        Iterator iterator2 = map.values().iterator();
        while (iterator2.hasNext()) {
            Object value = iterator2.next();
            System.out.println(value);
        }


    }
}
