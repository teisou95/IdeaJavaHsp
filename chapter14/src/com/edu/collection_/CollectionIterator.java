package com.edu.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@SuppressWarnings("all")
public class CollectionIterator {
    public static void main(String[] args) {
        Collection arrayList = new ArrayList();
        arrayList.add(new Book("三国演义", "罗贯中", 10.1));
        arrayList.add(new Book("小李飞刀", "古龙", 5.1));
        arrayList.add(new Book("红楼梦", "曹雪芹", 34.6));
        System.out.println("arrayList = " + arrayList);

        Iterator iterator = arrayList.iterator(); // 获取迭代器 // 迭代器本身不保存数据
        Iterator iterator1 = arrayList.iterator(); // 可以获取多个迭代器
        // 快捷键 itit 生成 while(iterator.hasNext()){}
        // ctrl + j 调出快捷方式模板
        while (iterator.hasNext()) { // 遍历集合
            Object obj = iterator.next();
            System.out.print(obj); // 返回下一个元素,Object对象
            System.out.println("    " + obj.getClass());
        }

//        iterator.next(); // NoSuchElementException
        // 再次遍历需要重置迭代器
        iterator = arrayList.iterator();
        System.out.println("第二次遍历");
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }

        // for 循环增强 遍历集合或数组
        // 底层仍然是迭代器
        // 快捷方式 I
        System.out.println("第三次遍历");
        for (Object obj :
                arrayList) {
            System.out.println(obj);
        }

        int[] numbers = new int[]{1, 2, 3, 4, 5};
        for (int i :
                numbers) {
            System.out.println("i = " + i);
        }
    }
}

@SuppressWarnings("all")
class Book {
    private String bookName;
    private String authorName;
    private double price;

    public Book(String bookName, String authorName, double price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", price=" + price +
                '}';
    }
}