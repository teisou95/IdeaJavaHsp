package com.edu.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

@SuppressWarnings({"all"})
public class Homework01 {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万,数百万印度教信徒赴恒河\"圣浴\"引民众担忧");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里,捞起一看赶紧放生");
        ArrayList newsArrayList = new ArrayList();
        newsArrayList.add(news1);
        newsArrayList.add(news2);
        //
        System.out.println("fori 循环打印");
        int size = newsArrayList.size();
        for (int i = size - 1; i >= 0; i--) {
            printNewsTitleMaxSize15(newsArrayList.get(i));
        }
        //
        System.out.println("for 循环打印");
        Collections.reverse(newsArrayList);
        for (Object news :newsArrayList) {
            printNewsTitleMaxSize15(news);
        }
        Collections.reverse(newsArrayList);
    }

    public static void printNewsTitleMaxSize15(Object obj) {
        if (!(obj instanceof News)) {
            throw new ClassCastException("类型转换错误");
        }
        News news = (News) obj;
        if (news.getTitle().length() < 16) {
            System.out.println(news);
        } else {
            String substring = news.getTitle().substring(0, 15);
            System.out.println(substring + "...");

//            char[] chars = Arrays.copyOf(news.getTitle().toCharArray(), 15);
//            for (Object o :chars) {
//                System.out.print(o);
//            }
//            System.out.println("...");
        }
    }
}

class News {
    private String title; //新闻标题
    private String content; // 新闻内容

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}