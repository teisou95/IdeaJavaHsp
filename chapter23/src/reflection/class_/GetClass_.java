package reflection.class_;

import reflection.Car;
import reflection.question.Cat;

/**
 * 得到Class对象的方式
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        // Class.forName
        // 多用于配置文件
        Class<?> aClass = Class.forName("reflection.Car");
        System.out.println(aClass);

        // 类名.class
        // 多用于参数传递 方法/构造器使用
        Class<Car> carClass = Car.class;
        System.out.println(carClass);
        System.out.println(String.class);

        // 对象.getClass
        Car car = new Car();
        Class<? extends Car> aClass1 = car.getClass();
        System.out.println(aClass1);

        // 通过类加载器(4种)
        // 先得到类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("reflection.Car");
        System.out.println(aClass2);

        // 同一个类 只有一个 Class 对象
        System.out.println(aClass.hashCode());
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(carClass.hashCode());

        // 基本数据类型.class
        Class<Integer> intClass = int.class;
        System.out.println(intClass); // int
        Class<Integer> integerClass = Integer.class;
        System.out.println(integerClass); // class java.lang.Integer

        // 包装类.TYPE
        Class<Integer> type = Integer.TYPE;
        System.out.println(type); // int
        Class<Character> type1 = Character.TYPE;
        System.out.println(type1); // char

        // 同一基本数据类型 还是只有一个Class对象
        System.out.println(intClass.hashCode());
        System.out.println(type.hashCode());

        // 包装类 和 基本数据类型 的 Class 对象不同
        System.out.println(integerClass.hashCode());
    }
}
