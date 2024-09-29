package com.edu.list_;

import java.util.ArrayList;
import java.util.List;

/**
 * List 接口 方法
 * List 集合类元素有序,可重复,支持索引 get(int index)
 */
public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("的巴士");
        list.add("tom"); // 可重复
        System.out.println("list = " + list); // 添加顺序与取出顺序一致
        System.out.println("list.get(1) = " + list.get(1)); // 支持索引

        // List 方法
        list.add(3,"酷酷酷"); // 指定位置插入元素
        System.out.println("list = " + list);

        List list2 = new ArrayList();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        list.addAll(1,list2); // 指定位置插入集合
        System.out.println("list = " + list);

        // indexOf 返回被查找元素在集合中首次出现的位置
        int index = list.indexOf("tom");
        System.out.println("index = " + index);
        int index1 = list.lastIndexOf("tom"); // 最后出现的位置
        System.out.println("index1 = " + index1);

        // remove
        list.remove(7); // 删除指定位置元素
        System.out.println("list = " + list);

        // set 设置-替换
        // 索引必须存在
        list.set(3,"哈哈"); // 指定位置 设置新对象
        System.out.println("list = " + list);

        // subList 返回子集合
        List subList = list.subList(1, 3); // 前闭后开
        System.out.println("subList = " + subList);
    }
}
