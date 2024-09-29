package com.edu.tankgame04;

import java.awt.*;
import java.io.Serializable;

public class EnemyTank extends Tank implements Runnable {
    private final int moveTimes; // 自动移动间隔时间
    private int moveNum; // 同方向移动次数

    public EnemyTank(int x, int y, int moveTimes) {
        super(x, y);
        this.moveTimes = moveTimes;
        setColor(Color.cyan);
        setSpeed(5);
        setLife(5);
        setDirection((int) (Math.random() * 4)); // 初始方向随机
    }

    @Override
    public void run() {
        while (isLive()) {
            try {
                Thread.sleep(moveTimes);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int direction = getDirection();
            if (moveNum <= 0) { // 本次方向移动结束
                direction = (int) (Math.random() * 4); // 产生随机方向并移动
                moveNum = (int) (Math.random() * Math.min((Math.min(getX(), getY()))
                        , Math.min(MyPanel.PANEL_WIDTH - getX() - getWidth()
                                , MyPanel.PANEL_HEIGHT - getY() - getHeight()))) / getSpeed();
            }
            int oldDirection = getDirection();
            switch (direction) {
                case 0: //上
                    moveUp();
                    break;
                case 1: // 右
                    moveRight();
                    break;
                case 2: // 下
                    moveDown();
                    break;
                case 3: // 左
                    moveLeft();
                    break;
            }
            moveNum--;
            if (MyPanel.checkClash()) setDirection(oldDirection % 2 == 0 ?
                    (int) (Math.random() * 2) * 2 : (int) (Math.random() * 2) + 2); // 检测改变横纵方向导致穿模
            checkBound(); // 检查坦克边界
            if (getBullets().size() < 3) { // 限制同时存在的子弹数量
                shoot(); // 自动发射子弹
            }
        }
        System.out.println(Thread.currentThread().getName() + " 敌方坦克线程退出");
    }
}
