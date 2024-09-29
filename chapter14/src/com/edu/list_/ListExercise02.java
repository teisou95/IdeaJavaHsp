package com.edu.list_;

import java.util.*;

public class ListExercise02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new Vector();
        list.add(new ChineseBook("红楼梦", "曹雪芹", 100));
        list.add(new ChineseBook("西游记", "吴承恩", 10));
        list.add(new ChineseBook("水浒传", "施耐庵", 9));
        list.add(new ChineseBook("三国", "罗贯中", 80));
        list.add(new ChineseBook("西游记", "吴承恩", 10));
        for (Object book : list) {
            ChineseBook book1 = (ChineseBook) book;
            System.out.println(String.format("名称:%s\t价格:%s\t作者:%s",
                    book1.getBookName(), book1.getPrice(), book1.getAuthorName()));
        }

        bubbleSort(list);
        // 转数组排序
//        Object[] toArray = list.toArray();
//        Arrays.sort(toArray, new Comparator<Object>() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                ChineseBook book = (ChineseBook) o1;
//                ChineseBook book1 = (ChineseBook) o2;
//                if (book.getPrice() > book1.getPrice()) {
//                    return 1;
//                } else if (book.getPrice() == book1.getPrice()) {
//                    return 0;
//                } else {
//                    return -1;
//                }
//            }
//        });
//        for (int i = 0; i < toArray.length; i++) {
//            list.set(i,toArray[i]);
//        }
        System.out.println("排序后===============");
        for (Object book : list) {
            ChineseBook book1 = (ChineseBook) book;
            System.out.println(String.format("名称:%s\t价格:%s\t作者:%s",
                    book1.getBookName(), book1.getPrice(), book1.getAuthorName()));
        }

    }

    public static void bubbleSort(List list) { // 价格从低到高 冒泡排序
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            boolean couhann = false; // 是否发生交换
            for (int j = 0; j < size - 1 - i; j++) {
                ChineseBook book = (ChineseBook) list.get(j);
                ChineseBook book1 = (ChineseBook) list.get(j + 1);
                if (book.getPrice() > book1.getPrice()) {
                    list.set(j, book1);
                    list.set(j + 1, book);
                    couhann = true; // 交换了
                }
            }
            if (!couhann) {
                return;
            }
        }
    }
}

class ChineseBook {
    private String bookName;
    private String authorName;
    private double price;

    public ChineseBook() {
    }

    public ChineseBook(String bookName, String authorName, double price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ChineseBook{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
