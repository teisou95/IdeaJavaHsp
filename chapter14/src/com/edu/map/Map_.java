package com.edu.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 0531
 * Map接口实现类的特点
 * 1.Map 和 Collection 并列存在,是两大类不同的集合
 * 2.Map用于保存具有映射关系的数据 :Key-Value ,双列元素
 * 3.无序(key 存放的时候按 hash值确定索引)
 * 4.Map 中的 key 和 value 可以是任何引用类型的数据,会封装到 HashMap$Node 对象中
 * 5.Map 中的 key 不允许重复,和 HashSet 原因一样
 * 6.Map 中 key和 value 都可以为null,但是key只能有一个null,value 可以有多个null
 * 7.常用String类做 key
 * 8.key 与 value 存在单向1对1关系,通过key 总是能找到对应的 value
 */
@SuppressWarnings({"all"})
public class Map_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1", "king");
        map.put("no2", "张三");
        map.put("no0", "hello");

        Object oldValue = map.put("no1", "尼斯");// 检查key相同时,就替换原key的oldValue,并返回 oldValue
//        System.out.println(oldValue);

        map.put("no3", "张三"); // value 可以重复

        map.put(null, "张三");
        map.put(null, "王五"); // key 不能重复,替换原来的value
        map.put("no4", null);
        map.put(null, null); // value 可以有多个null

        map.put(1,"娜娜");
        map.put(new Object(),"哈哈哈");

        // Map 不能用 直接for 遍历(包括增强for)
        // iterator 是Collection 集合独有的迭代器
        System.out.println(map); // 无序

        // 通过get方法 传入 key 会返回对应的 value
        System.out.println(map.get("no3"));


    }
}
