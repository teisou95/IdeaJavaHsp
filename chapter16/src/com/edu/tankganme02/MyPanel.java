package com.edu.tankganme02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

// 游戏绘图区域(界面)
public class MyPanel extends JPanel implements KeyListener {
    private HeroTank heroTank = null;
    private int enemyTankSize = 3;
    private Vector<EnemyTank> enemyTanks = new Vector<>(); // 多线程用Vector
    public static final int PANEL_WIDTH = 800;
    public static final int PANEL_HEIGHT = 600;

    public MyPanel() {
        heroTank = new HeroTank(PANEL_WIDTH / 2, PANEL_HEIGHT - 150); // 初始化自己的坦克
        // 初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            enemyTanks.add(new EnemyTank(i * 100 + 200,PANEL_HEIGHT / 4));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 填充矩形,游戏背景,默认黑色
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        // 画自己的坦克
        drawTank(heroTank.getX(), heroTank.getY(), g, heroTank.getDirection(), 0);

        // 画敌人的坦克
        for (EnemyTank enemyTank :enemyTanks) {
            enemyTank.setDirection(2);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirection(),1);
        }

    }

    /**
     * @param x         坦克左上角 X 坐标
     * @param y         坦克左上角 Y 坐标
     * @param g         画笔
     * @param direction 坦克方向(炮筒方向) 0-上, 1-右, 2-下, 3-左
     * @param type      坦克类型 0-自己, 1-敌人
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        // 根据坦克类型 设置不同的颜色
        switch (type) {
            case 0: // 自己的坦克
                g.setColor(Color.yellow);
                break;
            case 1: // 敌人的坦克(青)
                g.setColor(Color.cyan);
                break;
        }
        switch (direction) {
            case 0: // 朝上
                // 重设坦克宽高
                // 坦克两侧矩形,左上角作为整个坦克的坐标
                g.fill3DRect(x, y, 10, 60, false); // // 3D高亮矩形,边缘突出显示
                g.fill3DRect(x + 30, y, 10, 60, false);
                // 坦克中间矩形
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                // 坦克中间圆形
                g.fillOval(x + 10, y + 20, 20, 20);
                // 坦克炮筒
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1: // 朝右
                // 坦克两侧矩形
                g.fill3DRect(x, y, 60, 10, false); // // 3D高亮矩形,边缘突出显示
                g.fill3DRect(x, y + 30, 60, 10, false);
                // 坦克中间矩形
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                // 坦克中间圆形
                g.fillOval(x + 20, y + 10, 20, 20);
                // 坦克炮筒
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2: // 朝下
                // 坦克两侧矩形
                g.fill3DRect(x, y, 10, 60, false); // // 3D高亮矩形,边缘突出显示
                g.fill3DRect(x + 30, y, 10, 60, false);
                // 坦克中间矩形
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                // 坦克中间圆形
                g.fillOval(x + 10, y + 20, 20, 20);
                // 坦克炮筒
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3: // 朝左
                // 坦克两侧矩形
                g.fill3DRect(x, y, 60, 10, false); // // 3D高亮矩形,边缘突出显示
                g.fill3DRect(x, y + 30, 60, 10, false);
                // 坦克中间矩形
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                // 坦克中间圆形
                g.fillOval(x + 20, y + 10, 20, 20);
                // 坦克炮筒
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar() + "键被按下...");
        switch (Character.toUpperCase(e.getKeyChar())) {
            case 'W': // 向上
                if (heroTank.getDirection() == 0) heroTank.moveUp();
                heroTank.setDirection(0);
                heroTank.setWidth(40);
                heroTank.setHeight(60);
                break;
            case 'D': // 向右
                if (heroTank.getDirection() == 1) heroTank.moveRight();
                heroTank.setDirection(1);
                heroTank.setWidth(60);
                heroTank.setHeight(40);
                break;
            case 'S': // 向下
                if (heroTank.getDirection() == 2) heroTank.moveDown();
                heroTank.setDirection(2);
                heroTank.setWidth(40);
                heroTank.setHeight(60);
                break;
            case 'A': // 向左
                if (heroTank.getDirection() == 3) heroTank.moveLeft();
                heroTank.setDirection(3);
                heroTank.setWidth(60);
                heroTank.setHeight(40);
                break;
        }
        heroTank.checkBound(); // 检查边界
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
