package com.edu.list_;

import java.util.Vector;

public class Vector_ {
    public static void main(String[] args) {
        Vector vector = new Vector();
        // 无参构造器 默认调用有参构造this(10); 大小10
        // 每次检查空间是否足够,不够 grow()扩容到2倍
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        for (int i = 10; i < 20; i++) {
            vector.add(i);
        }
        vector.add(100);

        // 有参构造器,初始指定大小
        // 每次扩容2倍(指定0的话变为1)
        vector = new Vector(8);
        for (int i = 0; i < 5; i++) {
            vector.add(i);
        }
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }

        // 指定初始大小10,指定每次增长容量8
        Vector vector1 = new Vector(10, 8);
        for (int i = 0; i < 10; i++) {
            vector1.add(i);
        }
        vector1.add(100);
    }
}
