package com.edu.tankgame03;

import java.awt.*;

// 我方坦克
public class HeroTank extends Tank {
    public HeroTank(int x, int y) {
        super(x, y);
        setDirection(0);
        setSpeed(20);
        setLife(3);
        setColor(Color.yellow);
    }
}
