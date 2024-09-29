package reflection.question;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射
 * 根据配置文件创建对象,使用方法
 */
public class Question {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();
//        properties.setProperty("classfullpath","reflection.question.Cat");
//        properties.setProperty("method","cry");
//        properties.store(new FileWriter("src\\reflection\\question\\re.properties"),null);

        properties.load(new FileReader("src\\reflection\\question\\re.properties"));
        String classfullpath = properties.getProperty("classfullpath");
        String methodName = properties.getProperty("method");

        System.out.println("classfullpath = " + classfullpath);
        System.out.println("method = " + methodName);

        // 使用反射机制
        // 1.加载类 返回 Class 类型的对象
        Class cls = Class.forName(classfullpath);
        // 2.通过Class 对象得到加载的类的对象实例
        Object o = cls.newInstance();
        System.out.println("o.getClass() = " + o.getClass()); // o.getClass() = class reflection.question.Cat
        // 3.通过 cls 和方法名 得到加载的类的方法对象
        Method method = cls.getMethod(methodName);
//        Class<?> aClass = o.getClass();
//        System.out.println(aClass == cls);
//        Class<? extends Method> aClass1 = method.getClass();
//        System.out.println(aClass1);
        // 通过method 调用方法:方法.invoke(对象)
        method.invoke(o);

    }
}
