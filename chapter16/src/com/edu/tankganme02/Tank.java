package com.edu.tankganme02;

// 坦克父类
public class Tank {
    private int x; // 坦克横坐标
    private int y; // 纵坐标
    private int direction; // 方向,0上,1右,2下,3左
    private int width; // 宽度
    private int height; // 高度
    private int speed = 1; // 每次移动距离

    // 向上走
    public void moveUp() {
        y -= speed;
    }

    // 向右走
    public void moveRight() {
        x += speed;
    }

    // 向下走
    public void moveDown() {
        y += speed;
    }

    // 向左走
    public void moveLeft() {
        x -= speed;
    }
    // 检查边界
    public void checkBound() {
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x > MyPanel.PANEL_WIDTH - width) x = MyPanel.PANEL_WIDTH - width;
        if (y > MyPanel.PANEL_HEIGHT - height) y = MyPanel.PANEL_HEIGHT - height;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
