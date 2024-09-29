package reflection.class_;

import reflection.Car;

import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Class类的方法
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        String classFullPath = "reflection.Car";
        // 获取 Car 类对应的 Class 对象
        // <?> 表示不确定的java类型
        Class<?> aClass = Class.forName(classFullPath);
        System.out.println(aClass); // class reflection.Car
        System.out.println(aClass.getClass()); // class java.lang.Class
        // 得到包名
        Package aPackage = aClass.getPackage();
        System.out.println(aPackage); // package reflection
        System.out.println(aPackage.getName()); // reflection
        // 得到全类名
        String className = aClass.getName();
        System.out.println(className); // reflection.Car
        // 生成对象实例
        Object car = aClass.newInstance();
        System.out.println(car); // Car{brand='宝马', price=50, color='白色'}
        // 获取属性,私有属性报错
        Field brand = aClass.getField("brand");
        System.out.println(brand); // public java.lang.String reflection.Car.brand
        // 获取特定对象的属性的值
        Object brandValue = brand.get(car);
        System.out.println(brandValue); // 宝马
        // 给属性赋值
        brand.set(car,"奔驰");
        System.out.println(brand.get(car)); // 奔驰
        // 遍历所有的字段属性
        Field[] fields = aClass.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.print(fields[i].getName() + " "); // brand price color
        }
        // 获取方法
        Method getBrand = aClass.getMethod("getBrand");
        System.out.println("\n" + getBrand); // public void reflection.Car.getBrand()
        // 调用方法
        Object invoke = getBrand.invoke(car);
        System.out.println(invoke);
        // 获取所有方法
        Method[] methods = aClass.getMethods();
        // 获取构造器
        Constructor<?> constructor = aClass.getConstructor();
        Constructor<?>[] constructors = aClass.getConstructors();

    }
}
