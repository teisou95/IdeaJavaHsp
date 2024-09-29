package com.edu.homework;

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "src\\dog.properties";
        Properties properties = new Properties();
        properties.setProperty("name","tom");
        properties.setProperty("age","5");
        properties.setProperty("color","red");

        properties.store(new FileWriter(filePath),null);

        // 加载
        Properties p1 = new Properties();
        p1.load(new FileReader(filePath));

        // 取值
        String name = p1.getProperty("name");
        int age = Integer.parseInt(p1.getProperty("age"));
        String color = p1.getProperty("color");

        //
        Dog dog = new Dog(name, age, color);
        System.out.println(dog);

        // 序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src\\dog.dat"));
        objectOutputStream.writeObject(dog);
        objectOutputStream.close();

        // 反序列化
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\dog.dat"));
        Dog o = (Dog)objectInputStream.readObject();
        System.out.println(o);
        objectInputStream.close();
    }
}
 class Dog implements Serializable {
    String name;
    int age;
    String color;
    public static final long serialVersionUID = 1L;

     public Dog(String name, int age, String color) {
         this.name = name;
         this.age = age;
         this.color = color;
     }

     @Override
     public String toString() {
         return "Dog{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 ", color='" + color + '\'' +
                 '}';
     }
 }