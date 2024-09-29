package reflection.class_;

import reflection.question.Cat;

/**
 * Class类
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // Class类不能new 构造器是私有的 ,由系统构建(类加载器生成)
//        Class<Object> objectClass = new Class();

        //  ClassLoader类的 loadClass 方法
        //  return loadClass(name, false);
        Cat cat = new Cat();

        // 反射
        // 同一个类的加载只会有一次
        // ClassLoader类的 loadClass 方法
        Class<?> aClass = Class.forName("reflection.question.Cat");
        Object o = aClass.newInstance();
        Class<?> aClass1 = o.getClass();
        Class<? extends Cat> aClass2 = cat.getClass();
        Class<?> aClass3 = Class.forName("reflection.question.Cat");
        System.out.println(aClass.hashCode());
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());
        // 一个类只有一个对应的Class类对象
    }
}
