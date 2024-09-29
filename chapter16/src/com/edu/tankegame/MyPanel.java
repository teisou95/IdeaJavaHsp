package com.edu.tankegame;

import javax.swing.*;
import java.awt.*;

// 游戏绘图区域(界面)
public class MyPanel extends JPanel {
    private HeroTank heroTank = null;
    private EnemyTank enemyTank = null;

    public MyPanel() {
        heroTank = new HeroTank(380, 450); // 初始化自己的坦克
        enemyTank = new EnemyTank(200, 200);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 填充矩形,游戏背景,默认黑色
        g.fillRect(0, 0, 800, 600);

        // 画自己的坦克
        drawTank(heroTank.getX(), heroTank.getY(), g, 0, 0);

        // 画敌人的坦克
        for (int i = 0; i < 3; i++) {
            drawTank(enemyTank.getX() + i * 200, enemyTank.getY(), g, 0, (i + 1));
        }

    }

    /**
     * @param x         坦克左上角 X 坐标
     * @param y         坦克左上角 Y 坐标
     * @param g         画笔
     * @param direction 坦克方向(炮筒方向) 0-上, 1-下, 2-左, 3-右
     * @param type      坦克类型 0-自己, 1-敌人
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        // 根据坦克类型 设置不同的颜色
        switch (type) {
            case 0: // 自己的坦克
                g.setColor(Color.cyan);
                break;
            case 1: // 敌人的坦克(黄)
                g.setColor(Color.yellow);
                break;
            case 2: // 敌人的坦克(红)
                g.setColor(Color.red);
                break;
            case 3: // 敌人的坦克(绿)
                g.setColor(Color.green);
                break;
        }
        switch (direction) {
            case 0: // 朝上
                // 坦克两侧矩形,左履带左上角作为整个坦克的坐标
                g.fill3DRect(x, y, 10, 60, false); // // 3D高亮矩形,边缘突出显示
                g.fill3DRect(x + 30, y, 10, 60, false);
                // 坦克中间矩形
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                // 坦克中间圆形
                g.fillOval(x + 10, y + 20, 20, 20);
                // 坦克炮筒
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1: // 朝下
            case 2: // 朝左
            case 3: // 朝右
        }
//        // 辅助文字信息
//        g.setColor(Color.RED);
//        g.setFont(new Font("宋体", Font.PLAIN, 15));
//        g.drawString("坦克大战", x - 10, y - 10);
    }
}
