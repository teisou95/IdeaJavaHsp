package reflection.ClassLoader_;

import java.util.*;
import java.lang.reflect.*;

// 静态加载 编译时加载
public class ClassLoad_ {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入 key");
        String key = scanner.next();
        switch(key) {
            case "1" :
                Dog dog = new Dog(); // 静态加载 编译时加载
                dog.cry();
                break;
            case "2" :
                // 反射 -> 动态加载
                Class cls = Class.forName("Person"); // 动态加载 运行时加载 降低依赖性
                Object o = cls.newInstance();
                Method m = cls.getMethod("hi");
                m.invoke(o);
                System.out.println("ok");
                break;
            default:
                System.out.println("do nothing");
        }
    }
}

// new Dog() 是静态加载 必须编写Dog类
// Person 是动态加载 没有也不会报错,只有执行到语句时,才会报错
class Dog {
    public void cry() {
        System.out.println("小狗汪汪叫");
    }
}

class Person {
    public void hi() {
        System.out.println("小孩打招呼");
    }
}