package reflection.class_;

import java.io.Serializable;

/**
 * 哪些类型 有 Class对象
 */
public class AllTypeClass_ {
    public static void main(String[] args) {
        // 类 包括 内部类
        Class<String> stringClass = String.class;
        System.out.println("stringClass = " + stringClass);
        // 接口
        Class<Serializable> serializableClass = Serializable.class;
        System.out.println("serializableClass = " + serializableClass);
        // 数组
        Class<int[]> intArrayClass = int[].class;
        System.out.println("intArrayClass = " + intArrayClass);
        // 基本数据类型
        Class<Integer> intClass = int.class;
        System.out.println("intClass = " + intClass);
        // 二维数组
        Class<Float[][]> floatBinaryArrayClass = Float[][].class;
        System.out.println("floatBinaryArrayClass = " + floatBinaryArrayClass);
        // 注解
        Class<Deprecated> deprecatedClass = Deprecated.class;
        System.out.println("deprecatedClass = " + deprecatedClass);
        // 枚举
        Class<Thread.State> stateClass = Thread.State.class;
        System.out.println("stateClass = " + stateClass);
        // 包装类
        Class<Boolean> booleanClass = Boolean.class;
        System.out.println("booleanClass = " + booleanClass);
        // void
        Class<Void> voidClass = void.class;
        System.out.println("voidClass = " + voidClass);
        // Void 包装类
        Class<Void> voidClass1 = Void.class;
        System.out.println("voidClass1 = " + voidClass1);

        // Class
        Class<Class> classClass = Class.class;
        System.out.println("classClass = " + classClass);


    }
}
