package com.edu.tankgame03;

/**
 * 炸弹类
 * 爆炸效果
 */
public class Bomb{
     private int x; // 横坐标
     private int y; // 纵坐标
     private int life = 300; // 炸弹生命周期
     private boolean isLive = true; // 存活状态

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 减少生命值
     */
    public void lifeDown() {
        if (life > 0) {
            life--;
        }else {
            isLive = false;
        }
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
