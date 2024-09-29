package com.edu.homework;

import java.util.Scanner;

@SuppressWarnings({"unused"})
public class Homework08 {
    public static void main(String[] args) {
        System.out.println("输入一个颜色");
        Scanner scanner = new Scanner(System.in);
        String color = scanner.next().toUpperCase();
        Color1 realColor = Color1.valueOf(color);
        switch (realColor) {
            case RED: // An enum switch case label must be the unqualified name of an enumeration constant
                Color1.RED.show();
                break;
            case GREEN:
                Color1.GREEN.show();
                break;
            case BLACK:
                Color1.BLACK.show();
                break;
            case YELLOW:
                Color1.YELLOW.show();
                break;
            case BLUE:
                Color1.BLUE.show();
                break;
            default:
                System.out.println("输入错误");
        }

    }
}

interface IN {
    void show();
}

@SuppressWarnings({"unused"})
enum Color1 implements IN {
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    private final int redValue;
    private final int greenValue;
    private final int blueValue;

    Color1(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println(this.name() + ":");
        System.out.println("redValue = " + redValue);
        System.out.println("greenValue = " + greenValue);
        System.out.println("blueValue = " + blueValue);
    }
}
