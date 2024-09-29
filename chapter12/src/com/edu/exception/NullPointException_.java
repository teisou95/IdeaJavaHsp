package com.edu.exception;

/**
 * 空指针异常
 */
public class NullPointException_ {
    public static void main(String[] args) {
        String name = null;
        try {
            System.out.println(name.length());
        } catch (Exception e) {
            System.out.println(e);; // java.lang.NullPointerException
        }
    }
}
