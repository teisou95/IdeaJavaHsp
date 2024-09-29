package com.edu.tankgame04;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 坦克大战4.0版
 * 防止坦克重叠
 * 记录玩家成绩,存盘退出
 * 记录当时敌人坦克坐标,存盘退出
 * 玩游戏时,可以选择开新游戏还是继续上局游戏
 */
// 游戏窗口
public class TankGame04 extends JFrame {

    public static void main(String[] args) {
        TankGame04 tankGame01 = new TankGame04();
    }

    public TankGame04() {
        MyPanel myPanel = new MyPanel();
        Thread repaintThread = new Thread(myPanel);
        repaintThread.start();

        this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setSize(MyPanel.PANEL_WIDTH + 300, MyPanel.PANEL_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 添加窗口监听,退出前保存
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("监听到窗口退出");
                MyPanel.save();
                System.exit(0);
            }
        });
    }

}
