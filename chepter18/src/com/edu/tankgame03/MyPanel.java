package com.edu.tankgame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

// 游戏绘图区域(界面)
public class MyPanel extends JPanel implements KeyListener, Runnable {
    private static HeroTank heroTank = null;
    private static Vector<EnemyTank> enemyTanks = new Vector<>(); // 敌人坦克集合,多线程用Vector
    private Vector<Bullet> deadEnemyTankBullets = new Vector<>(); // 死亡敌方坦克的已射出子弹
    public static final int PANEL_WIDTH = 800;
    public static final int PANEL_HEIGHT = 600;

    // 初始化爆炸图片对象
    Image image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb1.png"));
    Image image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb2.png"));
    Image image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb3.png"));

    public MyPanel() {
        heroTank = new HeroTank(PANEL_WIDTH / 2, PANEL_HEIGHT - 150); // 初始化自己的坦克
        // 初始化敌人的坦克
        int enemyTankSize = 3;
        for (int i = 0; i < enemyTankSize; i++) {
            enemyTanks.add(new EnemyTank(i * 100 + 200, PANEL_HEIGHT / 4, 500));
            new Thread(enemyTanks.get(i)).start(); // 启动敌方坦克线程
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 填充矩形,游戏背景,默认黑色
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        // 检测我方坦克是否被击中
        for (EnemyTank enemyTank : enemyTanks) {
            heroTank.beingHit(enemyTank.getBullets());
        }
        heroTank.beingHit(deadEnemyTankBullets);

        //画我方坦克和子弹
        if (heroTank.isLive()) {
            drawTank(heroTank, g, 0);
        } else {
            Vector<Bullet> oldBullets = heroTank.getBullets();
            heroTank = new HeroTank(PANEL_WIDTH / 2, PANEL_HEIGHT - 150); // 复活
            heroTank.setBullets(oldBullets); // 继承原消亡坦克的子弹
        }
        drawBullet(heroTank.getBullets(), g); // 子弹已经打出去,不随着坦克消亡而消亡

        // 画敌方坦克和子弹
        Iterator<EnemyTank> iterator = enemyTanks.iterator();
        while (iterator.hasNext()) {
            EnemyTank enemyTank = iterator.next();
            enemyTank.beingHit(heroTank.getBullets()); // 检测敌方坦克是否被击中
            if (!enemyTank.isLive()) {
                deadEnemyTankBullets.addAll(enemyTank.getBullets()); // 继承已死亡坦克的子弹
                iterator.remove(); // 移除出敌方坦克集合
                continue;
            }
            drawTank(enemyTank, g, 1);
            drawBullet(enemyTank.getBullets(), g);
        }

        // 画已死亡敌方坦克的子弹
        drawBullet(deadEnemyTankBullets, g); // 存在 敌方坦克已死亡,但其子弹还存活的情况


        // 画炸弹(所有敌我方坦克的炸弹是共享的final 集合)
        drawBomb(Tank.getBombs(), g);

    }

    /**
     * 检测坦克碰撞
     *
     * @return 检测发生碰撞返回 true,无任何碰撞返回 false
     */
    public static boolean checkClash() {
        Vector<Tank> tanks = new Vector<>(enemyTanks);
        tanks.add(heroTank);
        for (Tank tank : tanks) {
            Vector<Tank> otherTanks = new Vector<>(tanks);
            otherTanks.remove(tank);
            for (Tank otherTank : otherTanks) {
                if ((Math.abs(tank.getX() - otherTank.getX()) < Math.min(tank.getWidth(), otherTank.getWidth())
                        && Math.abs(tank.getY() - otherTank.getY()) < Math.min(tank.getHeight(), otherTank.getHeight()))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 画炸弹
     *
     * @param bombs 炸弹集合
     * @param g     画笔
     */
    public void drawBomb(Vector<Bomb> bombs, Graphics g) {
        Iterator<Bomb> iterator = bombs.iterator();
        while (iterator.hasNext()) {
            Bomb bomb = iterator.next();
            if (!bomb.isLive()) { // 炸弹时间过了
                iterator.remove(); // 移除出炸弹集合
                continue;
            }
            if (bomb.getLife() > 200) {
                g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
            } else if (bomb.getLife() > 100) {
                g.drawImage(image2, bomb.getX(), bomb.getY(), 50, 50, this);
            } else {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 40, 40, this);
            }
            bomb.lifeDown(); // 炸弹时间推移
        }
    }

    /**
     * 画子弹
     * 使用增强for,抛出了并发修改对象异常,不允许一个线程在修改集合,另一个线程在迭代集合
     * 解決方案,使用for迭代集合的時候不能修改集合本身
     * 但是使用迭代器方法可以,通过iterator.remove
     *
     * @param bullets 子弹集合
     * @param g       画笔
     */
    public void drawBullet(Vector<Bullet> bullets, Graphics g) {
        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()) {
            Bullet bullet = iterator.next();
            if (!bullet.isLive()) {
                iterator.remove(); // 检测到子弹消亡,安全从子弹集合中移除当前子弹
                continue;
            }
            g.setColor(bullet.getColor());
            g.drawLine(bullet.getX(), bullet.getY(), bullet.getX(), bullet.getY());
        }
    }

    /**
     * 画坦克
     *
     * @param tank 坦克对象
     * @param g    画笔
     * @param type 坦克类型 0-自己, 1-敌人
     */
    public void drawTank(Tank tank, Graphics g, int type) {
        // 根据坦克类型 设置不同的颜色
        switch (type) {
            case 0: // 自己的坦克(黄)
                break;
            case 1: // 敌人的坦克(青)
                break;
        }
        g.setColor(tank.getColor());

        switch (tank.getDirection()) {
            case 0: // 朝上
                // 坦克两侧矩形,左上角作为整个坦克的坐标
                g.fill3DRect(tank.getX(), tank.getY(), 10, 60, false); // // 3D高亮矩形,边缘突出显示
                g.fill3DRect(tank.getX() + 30, tank.getY(), 10, 60, false);
                // 坦克中间矩形
                g.fill3DRect(tank.getX() + 10, tank.getY() + 10, 20, 40, false);
                // 坦克中间圆形
                g.fillOval(tank.getX() + 10, tank.getY() + 20, 20, 20);
                // 坦克炮筒
                g.drawLine(tank.getX() + 20, tank.getY() + 30, tank.getX() + 20, tank.getY());
                break;
            case 1: // 朝右
                // 坦克两侧矩形
                g.fill3DRect(tank.getX(), tank.getY(), 60, 10, false); // // 3D高亮矩形,边缘突出显示
                g.fill3DRect(tank.getX(), tank.getY() + 30, 60, 10, false);
                // 坦克中间矩形
                g.fill3DRect(tank.getX() + 10, tank.getY() + 10, 40, 20, false);
                // 坦克中间圆形
                g.fillOval(tank.getX() + 20, tank.getY() + 10, 20, 20);
                // 坦克炮筒
                g.drawLine(tank.getX() + 30, tank.getY() + 20, tank.getX() + 60, tank.getY() + 20);
                break;
            case 2: // 朝下
                // 坦克两侧矩形
                g.fill3DRect(tank.getX(), tank.getY(), 10, 60, false); // // 3D高亮矩形,边缘突出显示
                g.fill3DRect(tank.getX() + 30, tank.getY(), 10, 60, false);
                // 坦克中间矩形
                g.fill3DRect(tank.getX() + 10, tank.getY() + 10, 20, 40, false);
                // 坦克中间圆形
                g.fillOval(tank.getX() + 10, tank.getY() + 20, 20, 20);
                // 坦克炮筒
                g.drawLine(tank.getX() + 20, tank.getY() + 30, tank.getX() + 20, tank.getY() + 60);
                break;
            case 3: // 朝左
                // 坦克两侧矩形
                g.fill3DRect(tank.getX(), tank.getY(), 60, 10, false); // // 3D高亮矩形,边缘突出显示
                g.fill3DRect(tank.getX(), tank.getY() + 30, 60, 10, false);
                // 坦克中间矩形
                g.fill3DRect(tank.getX() + 10, tank.getY() + 10, 40, 20, false);
                // 坦克中间圆形
                g.fillOval(tank.getX() + 20, tank.getY() + 10, 20, 20);
                // 坦克炮筒
                g.drawLine(tank.getX() + 30, tank.getY() + 20, tank.getX(), tank.getY() + 20);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!heroTank.isLive()) {
            return;
        }
        int oldDirection = heroTank.getDirection();
        switch (Character.toUpperCase(e.getKeyChar())) {
            case 'W': // 向上
                heroTank.moveUp();
                break;
            case 'D': // 向右
                heroTank.moveRight();
                break;
            case 'S': // 向下
                heroTank.moveDown();
                break;
            case 'A': // 向左
                heroTank.moveLeft();
                break;
            case 'J': // 发射子弹
                if (heroTank.getBullets().size() < 5) { // 限制同时存在的子弹数量
                    heroTank.shoot();
                }
                break;
        }
        if (MyPanel.checkClash()) heroTank.setDirection(oldDirection % 2 == 0 ?
                (int) (Math.random() * 2) * 2 : (int) (Math.random() * 2) + 2); // 检测改变横纵导致穿模
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint(); // 让面板不停的重绘
        }
    }
}
