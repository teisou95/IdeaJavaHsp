package com.edu.byteIOstream;

import java.io.*;

/**
 * 对象处理字节流
 * 序列化
 * static 和 transient 属性不会被序列化
 */
public class ObjectOutputStream01 {
    public static void main(String[] args) throws IOException {
        String destFilePath = "D:\\date.dat"; // 序列化后 保存的文件格式 不是纯文本的
        Dog tom = new Dog("tom", 3,"打赏","白色","日本");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destFilePath));
        // 序列化数据
        oos.writeObject(tom);
        oos.writeObject(new Dog("jack",5,"散步","黑色","中国"));
        // 基本数据包装类都实现了 可串行化
        oos.writeInt(100); // int -> Integer extents Number -> implement Serializable
        oos.writeBoolean(true); // boolean -> Boolean
        oos.writeChar('a'); // char -> Character
        oos.writeDouble(13.5);
        // String
        oos.writeUTF("大街上jsdca142"); //
        System.out.println("数据序列化保存完毕");
        oos.close();
    }
}

/**
 * 实现 可序列化 接口
 * 属性也必须都 可串行化
 */
class Dog implements Serializable {
    private String name;
    private int age;
    private String hobby;
    private Master master = new Master();
    private static String nation;
    private transient String color;
    // 序列化的版本号,提高序列化的兼容性
    public static final long serialVersionUID = 1L;

    public Dog(String name, int age, String hobby, String color,String nation) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.color = color;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                ", color='" + color + '\'' +
                '}' + nation + " " + master;
    }
}

class Master implements Serializable {

}