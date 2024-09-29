package com.edu.object.tostring;

/**
 * toString() 方法,默认返回:全类名+@+哈希值的十六进制
 * 子类往往重写,用于返回对象的属性信息
 */
public class ToString {
    public static void main(String[] args) {
        /**
         * Object toString 方法源码
         * getClass().getName() :全类名(包名+类名)
         * Integer.toHexString():转十六进制
         *
         *     public String toString() {
         *         return getClass().getName() + "@" + Integer.toHexString(hashCode());
         *     }
         */
        Monster monster = new Monster("kankan","jojo",20);
        System.out.println("monster = " + monster); // 直接输出对象默认调用toString
        System.out.println("monster.toString() = " + monster.toString());
        System.out.println("monster.hashCode() = " + monster.hashCode());
        System.out.println("Integer.toHexString(monster.hashCode()) = " + Integer.toHexString(monster.hashCode()));
        System.out.println("Integer.toHexString(15) = " + Integer.toHexString(15));
    }

}
