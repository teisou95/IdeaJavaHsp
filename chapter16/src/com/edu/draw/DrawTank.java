package com.edu.draw;

import javax.swing.*;
import java.awt.*;

/**
 * 画一个坦克
 */
public class DrawTank extends JFrame {
    public static void main(String[] args) {
        DrawTank drawTank = new DrawTank();
    }

    public DrawTank() {
        this.add(new Panel());
        this.setSize(800, 600);
        this.setVisible(true);
    }
}

class Panel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 引入坦克背景
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tankGame.jpg"));
        g.drawImage(image, 0, 0, 800, 600, this);
//        g.fillRect(20,100,100,150);
        //换颜色
        g.setColor(Color.CYAN);
        // 坦克两侧矩形
        g.fillRect(70, 40, 10, 70);
        g.fillRect(100, 40, 10, 70);
        // 坦克中间矩形
        g.fillRect(80, 50, 20, 50);
        // 换颜色
        g.setColor(Color.BLUE);
        // 坦克中间圆形
        g.fillOval(80, 70, 20, 20);

        // 换颜色,画外框线
        g.setColor(Color.BLACK);
        // 坦克两侧矩形
        g.drawRect(70, 40, 10, 70);
        g.drawRect(100, 40, 10, 70);
        // 坦克中间矩形
        g.drawRect(80, 50, 20, 50);
        // 坦克中间圆形
        g.drawOval(80, 70, 20, 20);
        // 坦克炮筒
        g.drawLine(90, 70, 90, 40);

        // 辅助文字信息
        g.setColor(Color.RED);
        g.setFont(new Font("宋体", Font.PLAIN, 15));
        g.drawString("坦克大战", 60, 30);
    }
}