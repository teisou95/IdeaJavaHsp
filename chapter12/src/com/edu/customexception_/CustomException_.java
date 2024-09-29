package com.edu.customexception_;

/**
 * 自定义异常
 */
public class CustomException_ {
    public static void main(String[] args) {
        int age = 180;
        // 要求年龄在18-120之间,否则抛出异常
        if (!(age >= 18 && age <= 120)) {
            try {
                throw new AgeException("年龄需要在18-120之间");
            } catch (AgeException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("年龄范围正确");
        }
    }
}

// 自定义异常类
// 一般都是继承 RuntimeException,这样可以使用默认的处理机制
class AgeException extends RuntimeException {
    public AgeException(String message) { // 构造器
        super(message);
    }
}

