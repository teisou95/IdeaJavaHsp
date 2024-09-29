package com.edu.anotation_;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * 注解
 * 抑制警告
 */
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class SuppressWarnings_ {
    // 当不希望看到警告的时候,可以通过注释抑制警告信息
    // 可以指定的警告类型
    // all boxing null rawtypes unchecked unused ...
    // cast dep-ann deprecation finally hiding javadoc ...
    // 作用范围与位置相关, main方法上/ 类上/ 方法上/ 具体语句上
//    放置的位置 : @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
//    @SuppressWarnings({"rawtypes", "unchecked", "unused"})

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add("king");
        list.add("mary");
        int i;
        System.out.println(list.get(1));
    }
    public void f1() {
        List list = new ArrayList();
        list.add("jack");
        list.add("king");
        list.add("mary");
        int i;
        System.out.println(list.get(1));
    }
}
