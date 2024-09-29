package com.edu.set_;

import java.util.HashSet;
@SuppressWarnings({"all"})
/**
 * HashSet add 机制
 */
public class HashSet01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        System.out.println(hashSet.add("john")); // t
        System.out.println(hashSet.add("lucy")); // t
        System.out.println(hashSet.add("john")); // f
        System.out.println(hashSet.add("jack")); // t
        System.out.println(hashSet.add("Rose")); // t
        hashSet.remove("john");
        System.out.println("hashSet = " + hashSet);


        hashSet.clear();
        hashSet.add("lucy");
        System.out.println("\"lucy\".hashCode() = " + "lucy".hashCode());
        String lucy = new String("lucy");
        hashSet.add(lucy);
        System.out.println("lucy = " + lucy.hashCode());
        // 根据 hashCode()判断是否重复
        StringBuffer buffer = new StringBuffer("lucy");
        System.out.println("buffer = " + buffer.hashCode());
        hashSet.add(buffer); // T

        hashSet.add(new Dog100("tom"));
        hashSet.add(new Dog100("tom")); // T //新的Dog100 对象,并不重复
        hashSet.add(1);
        hashSet.add(1); // F
        hashSet.add(new Integer(1000));
        hashSet.add(new Integer(1000)); // F
        System.out.println(new Integer(1000).hashCode() == new Integer(1000).hashCode()); // T
        System.out.println("hashSet = " + hashSet);
        // hashSet = [Dog100{name='tom'}1956725890, Dog100{name='tom'}1163157884, lucy]


    }
}

class Dog100 {
    private String name;

    public Dog100(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog100{" +
                "name='" + name + '\'' +
                '}' + hashCode();
    }
}