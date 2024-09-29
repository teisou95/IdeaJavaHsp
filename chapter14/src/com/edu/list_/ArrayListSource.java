package com.edu.list_;
/**
 * ArrayList add 方法 底层源码 扩容机制
 */

import java.util.ArrayList;
@SuppressWarnings({"all"})
public class  ArrayListSource {
    public static void main(String[] args) {
        // 无参构造器 初始数组为0
        // 第一次添加 扩容为10
        // 再次添加 扩容1.5倍
        ArrayList arrayList = new ArrayList();
        // 源码:transient Object[] elementData;
        // transient 瞬间/短暂的,表示该属性不会被序列化(被忽略)
        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
        }
        for (int i = 11; i <= 15; i++) {
            arrayList.add(i);
        }
        arrayList.add(100);
        arrayList.remove(12);
        arrayList.add(200);
        arrayList.set(9,2000);
        arrayList.add(null);
        arrayList.get(5);


        // 指定大小的构造器 初始大小指定
        // 扩容按当前大小的1.5倍扩容(初始1的话会变为2)
        ArrayList arrayList1 = new ArrayList(8);
        for (int i = 0; i < 8; i++) {
            arrayList1.add(i);
        }
        for (int i = 8; i < 12; i++) {
            arrayList1.add(i);
        }
        arrayList1.add(500);

    }
}
