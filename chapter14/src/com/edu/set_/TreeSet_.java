package com.edu.set_;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * key compare 结果为 0就加不进去(只会替换 value)
 */
@SuppressWarnings({"all"})
public class TreeSet_ {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(); // 默认比较器
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("sp");
        treeSet.add("a");
//        treeSet.add(1); // 无法比较,抛异常

        System.out.println("treeSet = " + treeSet);

        // 通过有参构造器,可以传入比较器
        // 指定排序规则
        /*
        public TreeMap(Comparator<? super K> comparator) {
            this.comparator = comparator;
        }
         */
        TreeSet treeSet1 = new TreeSet(new Comparator() { // 传入 Comparator 接口 匿名内部类
            @Override
            public int compare(Object o1, Object o2) {
//                return ((String) o2).compareTo((String) o1); // String 默认先逐个比较字符

                if (o1 instanceof String && o2 instanceof String) {
                    return ((String) o1).length() - ((String) o2).length(); // 按String 长度排序
                }
                return 0;


//                String s1 = (String) o1;
//                String s2 = (String) o2;
//                return s1.length() - s2.length();
            }

        });

        treeSet1.add("kk");
        treeSet1.add("pp"); // 按length比较 加不进去
        treeSet1.addAll(treeSet);

        System.out.println("treeSet1 = " + treeSet1);

        TreeSet treeSet2 = new TreeSet();
        treeSet2.add(52);
        treeSet2.add(120); // 默认 key.compareTo(t.ket)
//        treeSet2.add("jack"); // 无法比较.抛异常

    }
}
