package com.edu.byteIOstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 反序列化
 */
public class ObjectInputStream01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String srcFilePath = "D:\\date.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(srcFilePath));

        // 读取顺序(反序列化) 要和 存放顺序(序列化)一致
        /*
         // 序列化数据
        oos.writeObject(tom);
        oos.writeObject(new Dog("jack",5));
        // 基本数据包装类都实现了 可串行化
        oos.writeInt(100); // int -> Integer extents Number -> implement Serializable
        oos.writeBoolean(true); // boolean -> Boolean
        oos.writeChar('a'); // char -> Character
        oos.writeDouble(13.5);
        // String
        oos.writeUTF("大街上jsdca142"); //
        System.out.println("数据序列化保存完毕");
         */
        Object o = ois.readObject();
        System.out.println("o = " + o);
        System.out.println("o.getClass() = " + o.getClass());
        Object o1 = ois.readObject();
        System.out.println("o1 = " + o1);
        int i = ois.readInt();
        System.out.println("i = " + i);
        boolean b = ois.readBoolean();
        System.out.println("b = " + b);
        char c = ois.readChar();
        System.out.println("c = " + c);
        double v = ois.readDouble();
        System.out.println("v = " + v);
        String s = ois.readUTF();
        System.out.println("s = " + s);

        // 需要引入对象包,或将类的定义拷贝到可以引用的地方
        Dog dog = (Dog) o;
        int age = dog.getAge();
        System.out.println("age = " + age);
        System.out.println("反序列化完毕");
        ois.close();
    }
}
