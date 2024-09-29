package com.edu.tankgame03;

import java.awt.*;
import java.util.Vector;

// 坦克父类
public class Tank {
    private int x; // 坦克横坐标
    private int y; // 纵坐标
    private int direction; // 方向,0上,1右,2下,3左
    private int width; // 坦克宽度
    private int height; // 坦克高度
    private int speed = 5; // 每次移动距离
    private int life; // 坦克生命值
    private Vector<Bullet> bullets = new Vector<>(); // 子弹集合
    private Color color; // 坦克颜色
    private boolean isLive = true;
    private static Vector<Bomb> bombs = new Vector<>(); // 炸弹集合

    // 向上走
    public void moveUp() {
        y -= speed;
        direction = 0;
        checkBound();
        while (MyPanel.checkClash()) {
            y++;
            direction = (int) (Math.random() * 4);
        }
    }

    // 向右走
    public void moveRight() {
        x += speed;
        direction = 1;
        checkBound();
        while (MyPanel.checkClash()) {
            x--;
            direction = (int) (Math.random() * 4);
        }
    }

    // 向下走
    public void moveDown() {
        y += speed;
        direction = 2;
        checkBound();
        while (MyPanel.checkClash()) {
            y--;
            direction = (int) (Math.random() * 4);
        }
    }

    // 向左走
    public void moveLeft() {
        x -= speed;
        direction = 3;
        checkBound();
        while (MyPanel.checkClash()) {
            x++;
            direction = (int) (Math.random() * 4);
        }
    }

    // 发射子弹
    public void shoot() {
        Bullet bullet = null;
        if (direction == 0) {
            // 创建子弹线程,加入子弹集合,并启动此线程
            bullet = new Bullet(x + 20, y, 0, color);
        }
        if (direction == 1) {
            bullet = new Bullet(x + 60, y + 20, 1, color);
        }
        if (direction == 2) {
            bullet = new Bullet(x + 20, y + 60, 2, color);
        }
        if (direction == 3) {
            bullet = new Bullet(x, y + 20, 3, color);
        }
        bullet.start();
        bullets.add(bullet);
    }

    /**
     * 检查坦克边界
     */
    public void checkBound() {
        if (x < 0) {
            x = 0;
            direction = (int) (Math.random() * 4);
        }
        if (y < 0) {
            y = 0;
            direction = (int) (Math.random() * 4);
        }
        if (x > MyPanel.PANEL_WIDTH - width) {
            x = MyPanel.PANEL_WIDTH - width;
            direction = (int) (Math.random() * 4);
        }
        if (y > MyPanel.PANEL_HEIGHT - height) {
            y = MyPanel.PANEL_HEIGHT - height;
            direction = (int) (Math.random() * 4);
        }
    }


    /**
     * 检测坦克被击中
     */
    public void beingHit(Vector<Bullet> bullets) {
        // 遍历子弹
        if (!this.isLive) {
            return;
        }
        for (Bullet bullet : bullets) {
            if (bullet.getX() >= x && bullet.getY() >= y
                    && bullet.getX() <= x + width
                    && bullet.getY() <= y + height) { // 如果当前坦克被某对方子弹击中
                life--; // 生命值减少
                bullet.setLive(false); // 子弹也同归于尽了
                if (life <= 0) {
                    isLive = false; // 当前坦克死亡
                    bombs.add(new Bomb(x, y)); // 添加炸弹
                    System.out.println(this + " 坦克死亡");
                }
                System.out.println(this + " 坦克被击中" + " 剩余生命值 " + life);
            }
        }
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
        switch (this.direction) {
            case 0:
            case 2:
                width = 40;
                height = 60;
                break;
            case 1:
            case 3:
                width = 60;
                height = 40;
                break;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public static Vector<Bomb> getBombs() {
        return bombs;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
