package com.edu.poly.feed;

/**
 * 引出 多态
 * 提高方法的复用性,利于代码维护
 */
public class Poly01 {
    public static void main(String[] args) {
        Fish sakana = new Fish("sakana");
        Bone hone = new Bone("hone");
        Rice kome = new Rice("kome");
        Cat neko = new Cat("neko");
        Dog inu = new Dog("inu");
        Pig buta = new Pig("buta");
        Master shujinn = new Master("shujinn");

        shujinn.feed(neko, sakana);
        shujinn.feed(inu, hone);
        shujinn.feed(buta, kome);
    }
}
