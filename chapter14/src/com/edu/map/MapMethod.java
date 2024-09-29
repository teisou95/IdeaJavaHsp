package com.edu.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Map 接口方法
 */
@SuppressWarnings({"all"})
public class MapMethod {
    public static void main(String[] args) {
        Map map = new HashMap();
        // 添加 put(key,value)
        map.put("邓超",new Book("",100));
        map.put("邓超","孙俪"); // key相同 替换
        map.put("王宝强","马蓉");
        map.put("宋喆","马蓉");
        map.put("刘宁波",null);
        map.put(null,"刘亦菲");
        map.put("鹿晗","关晓彤");

        System.out.println(map); // 无序
//        for (Object o : map.entrySet()) {
//            System.out.println(o); // 无序
//        }

        // 根据 key 删除 k-v
        map.remove(null);
        System.out.println(map);

        // 根据 key 获取value
        System.out.println("map.get(\"刘亦菲\") = " + map.get("刘亦菲"));

        // size 获取 k-v 对数
        System.out.println(map.size());

        // 清空
//        map.clear();

        // isEmpty 判断个数是否为0
        System.out.println("map.isEmpty() = " + map.isEmpty());

        // 查找key是否存在
        System.out.println("map.containsKey(\"王宝强\") = " + map.containsKey("王宝强"));
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}