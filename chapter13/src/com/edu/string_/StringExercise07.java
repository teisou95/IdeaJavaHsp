package com.edu.string_;

/**
 * String 对象是通过引用传递的，但由于 String 的不可变性，
 * 任何对 String 的修改都会生成一个新的对象，而不是修改原来的对象。
 * 因此，尽管传递的是引用，但看起来像是值传递，
 * 这就是为什么在方法内部改变 String 变量的值不会影响原始变量的原因。
 */
public class StringExercise07 {
    public static void main(String[] args) {
        Test test = new Test();
        test.change(test.str, test.ch);
        System.out.println(test.str + "and");
        System.out.println(test.ch);
    }
}

class Test {
    String str = new String("abc");
    final char[] ch = {'j', 'a', 'v', 'a'};

    public void change(String str, char[] ch) {
        str = "java";
        ch[0] = 'h';
    }
}
