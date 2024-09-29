package com.edu.tankgame04;

import java.awt.*;
import java.io.Serializable;

// 子弹类,像素点
public class Bullet extends Thread implements Serializable {
    private int x; // 横坐标
    private int y; // 纵坐标
    private final int direction; // 子弹方向,0上,1右,2下,3左,方向不能改变
    private int sleepTime = 5; // 子弹移动休眠时间,反向体现出移动速度,初始设置为5(即每休眠 5毫秒后 移动 1个像素),休眠时间越短速度越快
    private Color color; // 子弹颜色
    private boolean isLive = true; // 子弹存活状态

    @Override
    public void run() {
        while (isLive) {
            // 检测子弹到达边界,结束当前子弹线程
            if (x <= 0 || y <= 0 || x >= MyPanel.PANEL_WIDTH || y >= MyPanel.PANEL_HEIGHT) {
                isLive = false;
                break;
            }
            switch (direction) {
                case 0: // 向上
                    y -= 1;
                    break;
                case 1: // 向右
                    x += 1;
                    break;
                case 2: // 向下
                    y += 1;
                    break;
                case 3: // 向左
                    x -= 1;
                    break;
            }
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Bullet(int x, int y, int direction, Color color) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        this.isLive = live;
    }
}
