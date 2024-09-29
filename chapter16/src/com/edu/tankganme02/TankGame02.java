package com.edu.tankganme02;

import javax.swing.*;

// 游戏窗口
public class TankGame02 extends JFrame {
    private MyPanel myPanel = null;

    public static void main(String[] args) {
        TankGame02 tankGame01 = new TankGame02();
    }

    public TankGame02() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setSize(MyPanel.PANEL_WIDTH, MyPanel.PANEL_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
