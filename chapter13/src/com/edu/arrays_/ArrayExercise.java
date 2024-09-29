package com.edu.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 0485
 * 定制排序
 */
public class ArrayExercise {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book("AAAA",100);
        books[1] = new Book("BB",90);
        books[2] = new Book("CCCCC",5);
        books[3] = new Book("DDD",300);
        books[4] = new Book("E",90.3);
        // 价格从小到大
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                double priceVS = book1.getPrice() - book2.getPrice();
                if (priceVS > 0) {
                    return 1;
                } else if (priceVS < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(books));

        // 价格从大到小
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                double priceVS = book1.getPrice() - book2.getPrice();
                if (priceVS > 0) {
                    return -1;
                } else if (priceVS < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(books));

        // 书名长度从小到大
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                return book1.getName().length() - book2.getName().length();
            }
        });
        System.out.println(Arrays.toString(books));
    }
}
class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
