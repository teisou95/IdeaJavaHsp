package com.edu.stringbuffer_;

import java.util.Scanner;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品名称");
        String name = scanner.next();
        System.out.println("请输入商品价格");
        String price = scanner.next();

        StringBuffer priceSb = new StringBuffer(price);
        int index = priceSb.lastIndexOf(".") - 3;
        while (index > 0) {
            priceSb.insert(index, ",");
            index -= 3;
        }
        System.out.println(name + "\t" + priceSb);
    }
}
