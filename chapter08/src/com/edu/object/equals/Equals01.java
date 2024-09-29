package com.edu.object.equals;

/**
 * == 和 equals 的区别
 * == : 比较运算符,判断基本类型的值是否相等,引用类型的地址是否相等
 * equals 是Object 类中的方法,只能用于判断引用类型,默认是判断地址是否相等
 * 但子类中往往重写该方法,用于判断内容相等,如String Integer 中的 equals的重写方法
 */
public class Equals01 {
    public static void main(String[] args) {
        int i = 10;
        double d = 10.0;
        // == 操作符使用时会进行自动数据转换
        System.out.println(1 == 1.0); // T
        System.out.println((i == d)); // T
        A a = new A();
        A b = a;
        A c = b;
        System.out.println(a == c); // T 判断地址
        System.out.println(b == c); // T
        B b1 = a;
        System.out.println(b1 == c); // T 地址相等

        // equals 方法源代码查看,CTRL+B
        "hello".equals("abc");
        /**
         * JDK中Object 类中的equals方法,直接判断引用地址
         *     public boolean equals(Object obj) {
         *         return (this == obj);
         *     }
         *
         *
         * JDK中 String 类中重写的 equals 方法源码:
         *  public boolean equals(Object anObject) {
         *         if (this == anObject) { // 地址相同,同一个对象
         *             return true;
         *         }
         *         if (anObject instanceof String) { // 运行类型属于 String
         *             String anotherString = (String)anObject; // 向下转型
         *             int n = value.length; // 对象字符串长度
         *             if (n == anotherString.value.length) { // 如果长度相同
         *                 char v1[] = value; // 转为char数组
         *                 char v2[] = anotherString.value;
         *                 int i = 0;
         *                 while (n-- != 0) { // 挨个比较字符
         *                     if (v1[i] != v2[i])
         *                         return false; // 有一个字符不同就返回 false
         *                     i++;
         *                 }
         *                 return true; // 全部字符相同返回true
         *             }
         *         }
         *         return false; // 传参不是字符串,或长度不同,返回 false
         *     }
         */
        Integer integer = new Integer(5000);
        System.out.println(integer.intValue());
        Integer integer1 = new Integer(5000);
        System.out.println(integer == integer1); // F 地址不同
        System.out.println(integer.equals(integer1)); // T 值相同

        String str1 = new String("rang");
        String str2 = new String("rang");
        System.out.println(str1 == str2); // F
        System.out.println(str1.equals(str2)); // T

    }
}
class B { // 父类

}
class A extends B{ // 子类

}
