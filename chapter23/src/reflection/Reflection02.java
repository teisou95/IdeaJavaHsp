package reflection;

import reflection.question.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试反射调用的性能 和 优化方案
 * 反射比传统方式 性能下降非常大
 * 关闭访问检查 可以 略微提高性能
 */
public class Reflection02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        m1();
        m2();
        m3();
    }

    // 传统方法调用Cat hi
    public static void m1() {
        Cat cat = new Cat();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("传统 耗时 = " + (endTime - startTime));
    }

    // 反射调用
    public static void m2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("reflection.question.Cat");
        Object o = aClass.newInstance();
        Method hi = aClass.getMethod("hi");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射 耗时 = " + (endTime - startTime));
    }

    // 反射调用优化
    public static void m3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("reflection.question.Cat");
        Object o = aClass.newInstance();
        Method hi = aClass.getMethod("hi");
        hi.setAccessible(true); // 反射调用方法时 取消访问检查
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射优化 耗时 = " + (endTime - startTime));
    }
}
