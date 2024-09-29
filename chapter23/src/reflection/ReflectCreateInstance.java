package reflection;

import javax.swing.plaf.nimbus.State;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射创建实例
 */
public class ReflectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
//        Class<?> userClass = Class.forName("reflection.User");
        Class<User> userClass = User.class;
        // public无参
        Object o = userClass.newInstance();
        System.out.println("o = " + o);

        // public有参构造
        Constructor<User> constructor = userClass.getConstructor(String.class);
        User tom = constructor.newInstance("tom");
        System.out.println("tom = " + tom);
        Field age = userClass.getDeclaredField("age");
        //反射机制可以设置 private 属性
        age.setAccessible(true); // 设置可访问属性age,爆破
        age.set(tom,100);
        System.out.println("tom = " + tom);

        // 非public有参构造 反射机制可以使用 private 构造器
        Constructor<User> declaredConstructor = userClass.getDeclaredConstructor(String.class, int.class);
//        User mary = declaredConstructor.newInstance("mary", 50); // 直接 new 不行,private不可访问
        declaredConstructor.setAccessible(true); // 设置可访问性,爆破
        User mary = declaredConstructor.newInstance("mary", 50);
        System.out.println("mary = " + mary);
    }
}

class User {
    private String name = "jack";
    private int age = 25;

    public User() { // 无参
    }

    private User(String name, int age) { // 私有2参
        this.name = name;
        this.age = age;
    }

    public User(String name) { // 公有1参
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}