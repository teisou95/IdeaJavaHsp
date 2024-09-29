package com.edu.enumeration_;

/**
 * 枚举类 隐式地 继承了 enum 类,不能再继承其他类,但可以实现接口
 */
public class EnumDetail {
    public static void main(String[] args) {
        Season10.CLASSICAL.play();
    }
}

enum Season10 implements IA{ // No extends clause allowed for enum
    CLASSICAL;

    @Override
    public void play() {
        System.out.println("播放音乐" + this.name());
    }

}
class A {
}
interface IA {
    public void play();
}