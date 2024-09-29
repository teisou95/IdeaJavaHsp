package com.edu.enumeration_;

/**
 * @author TeiSou
 * @version 1.0
 * 在 Java 中，所有枚举类型都继承自 java.lang.Enum 类，
 * 而 Enum 类已经提供了一个 toString() 方法。Enum 类的 toString() 方法返回枚举常量的名称，
 * 这个名称就是枚举常量在代码中定义时的名称。
 */
public class EnumerationTest {
    public static void main(String[] args) {
        System.out.println(Gender.BOY); // BOY
    }
}
enum Gender {
    BOY,GIRL; // 调用了无参构造器,创建了两个枚举对象

    @Override
    public String toString() {
        return super.toString();
    }
}