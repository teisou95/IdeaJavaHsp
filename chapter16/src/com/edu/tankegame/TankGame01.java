package com.edu.tankegame;

import javax.swing.*;

// 游戏窗口
public class TankGame01 extends JFrame {
    private MyPanel myPanel = null;

    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
    }

    public TankGame01() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
