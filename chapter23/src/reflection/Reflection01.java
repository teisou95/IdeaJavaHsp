package reflection;


import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射
 * 根据配置文件创建对象,使用方法
 */
public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\reflection\\question\\re.properties"));
        String classfullpath = properties.getProperty("classfullpath");
        String methodName = properties.getProperty("methodName");
        String fieldName = properties.getProperty("fieldName");

        Class<?> aClass = Class.forName(classfullpath);
        Object instance = aClass.newInstance();
        Method method = aClass.getMethod(methodName);
        method.invoke(instance); // 成员方法.invoke(对象)

        Field field = aClass.getField(fieldName); // 不能得到私有的属性
        System.out.println("字段在某个对象上的值 " + field.get(instance)); // 成员变量对象.get(对象)

        Constructor<?> constructor1 = aClass.getConstructor(); // ()可以指定构造器参数类型,不写返回无参构造器
        System.out.println("无参构造器 " + constructor1); // public reflection.question.Cat()
        Constructor<?> constructor2 = aClass.getConstructor(String.class);
        System.out.println("带 String 参数的构造器 " + constructor2); // public reflection.question.Cat(java.lang.String)
    }
}
