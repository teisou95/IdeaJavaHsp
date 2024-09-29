package com.edu.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 集合工具类
 * static 工具方法
 */
@SuppressWarnings({"all"})
public class collections_util {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tom");
        arrayList.add("ja");
        arrayList.add("king");
        arrayList.add("smith");
        arrayList.add("1");
        arrayList.add("tom");
        System.out.println(arrayList);

        // 反转
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        // 元素频次
        int frequency = Collections.frequency(arrayList, "king");
        System.out.println(frequency);

        // 打乱随机排序 => 本质 遍历数组 随机交换
//        Collections.shuffle(arrayList);
//        for (int i = 0; i < 5; i++) {
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
//        }

        // 自然排序 sort,默认compareTo
        Collections.sort(arrayList); // 数组必须是同一类型
        System.out.println(arrayList);

        // 指定排序 传入比较器 // 数组必须是同一类型
        Collections.sort(arrayList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    return ((String) o1).length() - ((String) o2).length();
                }
                return 0;
            }
        });
        System.out.println(arrayList);

        // swap 交换 指定索引位置
        Collections.swap(arrayList,1,2);
        System.out.println(arrayList);

        // max 根据自然排序的最大值
        Comparable max = Collections.max(arrayList);
        System.out.println(max);

        // 根据比较器的最大值
        String max1 = Collections.max(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println("max1 = " + max1);

        // min 自然排序
        Comparable min = Collections.min(arrayList);
        System.out.println("min = " + min);

        // min 指定排序
        String min1 = Collections.min(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        System.out.println("min1 = " + min1);

        // 频次
        int frequency1 = Collections.frequency(arrayList, "tom");
        System.out.println("frequency1 = " + frequency1);

        // 拷贝
        ArrayList desk = new ArrayList();
//        desk.addAll(arrayList);
//        desk.set(0,"hahahha");
        for (int i = 0; i < arrayList.size(); i++) {
            desk.add("");
        }
        System.out.println("desk = " + desk);
        Collections.copy(desk,arrayList); // dest.size 必须 不小于 src.size 才能 copy
        System.out.println("desk = " + desk);

        // replace 替换所有指定 oldValue
        Collections.replaceAll(arrayList,"tom","汤姆");
        System.out.println("arrayList = " + arrayList);
    }
}
