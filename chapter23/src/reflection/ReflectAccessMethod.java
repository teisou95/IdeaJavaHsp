package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射爆破方法
 */
public class ReflectAccessMethod {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Boss> bossClass = Boss.class;
        Boss boss = bossClass.newInstance();

        Method hi = bossClass.getMethod("hi", String.class);
        Object hiReturn = hi.invoke(boss, "哈哈");
        System.out.println("hiReturn = " + hiReturn);
//        System.out.println("hiReturn.getClass() = " + hiReturn.getClass()); // 空指针异常

        Method say = bossClass.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        Object returnValue = say.invoke(null, 3, "pp", '就');
        System.out.println("returnValue = " + returnValue);
    }
}

class Boss {
    private static String name;
    public int age;

    public Boss() {
    }

    private static String say(int n,String s,char c) {
        System.out.println("拉拉哒");
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi " + s);
    }
}