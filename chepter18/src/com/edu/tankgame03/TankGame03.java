package com.edu.tankgame03;

import javax.swing.*;

/**
 * 坦克大战3.0版
 * 可以发射子弹,互相攻击,死亡特效
 * 敌方坦克自由移动,自由发射
 */
// 游戏窗口
public class TankGame03 extends JFrame {

    public static void main(String[] args) {
        TankGame03 tankGame01 = new TankGame03();
    }

    public TankGame03() {
        MyPanel myPanel = new MyPanel();
        Thread repaintThread = new Thread(myPanel);
        repaintThread.start();

        this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setSize(MyPanel.PANEL_WIDTH, MyPanel.PANEL_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
