package reflection;

import org.junit.FixMethodOrder;
import org.junit.Test;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 通过反射获取类的结构信息
 */
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    //API 02
    @Test
    public void api_02() throws ClassNotFoundException {
        Class<?> personClass = Class.forName("reflection.Person");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) {
            // public 1
            // protected 4
            // 默认 0
            // private 2
            // static 8
            // final 16
            System.out.println("本类所有属性 = " + field.getName() + " 修饰符值 = " + field.getModifiers() +
                    " 类型 = " + field.getType().getSimpleName());
        }

        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类所有方法 = " + declaredMethod.getName() + " 修饰符值 = " + declaredMethod.getModifiers() +
                    " 方法返回类型 = " + declaredMethod.getReturnType().getSimpleName());
            System.out.println("该方法参数类型数组情况");
            System.out.println("参数个数= " + declaredMethod.getParameterCount());
            Class<?>[] parameters = declaredMethod.getParameterTypes();
            for (Class<?> parameter : parameters) {
                System.out.println(parameter.getSimpleName());
            }
        }

        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类所有构造器 = " + declaredConstructor + " 修饰符值 = " + declaredConstructor.getModifiers());
            System.out.println("构造器参数类型数组");
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getSimpleName());
            }
        }


    }

    //API 01
    @Test
    public void api_01() throws ClassNotFoundException {
        // 得到Class对象
        Class<?> personClass = Class.forName("reflection.Person");

        System.out.println("全类名 = " + personClass.getName());

        System.out.println("简单类名 = " + personClass.getSimpleName());

        // 得到所有public 修饰的属性,包括父类
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println("本类及父类的public 属性 = " + field.getName());
        }
        // 得到本类所有属性
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类所有属性 = " + declaredField);
        }

        // 得到本类及所有父类所有public方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println("本类及父类所有public方法 = " + method);
        }
        // 得到本类所有方法
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Field declaredField : declaredFields) {
            System.out.println("得到本类所有方法 = " + declaredField);
        }
        // 得到本类所有public构造器
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("得到本类所有public构造器 = " + constructor);
        }
        // 得到本类所有构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("得到本类所有构造器 = " + declaredConstructor);
        }
        // 得到包
        Package aPackage = personClass.getPackage();
        System.out.println("得到包 = " + aPackage);
        // 以Class 形式返回直接父类信息
        Class<?> superclass = personClass.getSuperclass();
        System.out.println("以Class 形式返回直接父类信息 = " + superclass);
        // 得到全部接口
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("得到全部接口 = " + anInterface);
        }
        // 得到注解信息
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("得到注解信息 = " + annotation);
        }

    }
}

class A {
    public String hobby;

    public void hi() {
    }

    public A() {
    }
}

interface IA {

}

interface IB {
}

@Deprecated
@FixMethodOrder
class Person extends A implements Serializable, IA, IB {
    public String name;
    protected static int age;
    final String job = " ";
    private double sal;

    public Person() {
    }

     Person(String name) {
        this.name = name;
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void m1(String name, int age, double sal) {
    }

    protected String m2() {
        return null;
    }

    void m3() {
    }

    private void m4() {
    }
}
