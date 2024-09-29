package com.edu.tankgame04;

import java.awt.*;

// 我方坦克
public class HeroTank extends Tank {
    private int killCount = 0; // 杀敌数
    public HeroTank(int x, int y) {
        super(x, y);
        setDirection(0);
        setSpeed(20);
        setLife(3);
        setColor(Color.yellow);
    }

    public int getKillCount() {
        return killCount;
    }

    // 杀敌数+1
    public void kill() {
        killCount++;
    }
}
