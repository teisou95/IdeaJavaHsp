package com.edu.tankganme02;

// 自己的坦克
public class HeroTank extends Tank {
    public HeroTank(int x, int y) {
        super(x, y);
//        setDirection(0); // 默认本来就是0
        setSpeed(20);
    }
}
