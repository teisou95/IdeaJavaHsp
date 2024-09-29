package com.edu.draw;

import javax.swing.*;
import java.awt.*;

/**
 * 画一只乌龟
 */
public class DrawExercise extends JFrame {
    private ExercisePanel panel = null;

    public DrawExercise() {
        panel = new ExercisePanel();
        this.add(panel);
        this.setSize(800,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        DrawExercise drawExercise = new DrawExercise();

    }
}
class ExercisePanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 身子
        g.setColor(Color.red);
        g.fillOval(100,100,100,140);
        // 头
        g.setColor(Color.green);
        g.fillRect(140,80,20,20);
        g.fillOval(135,55,30,30);
        // 四肢
        g.fillArc(95,115,30,30,60,90);
        g.fillArc(177,115,30,30,120,-90);
        g.fillArc(95,197,30,30,-60,-90);
        g.fillArc(177,197,30,30,240,90);
        // 眼睛
        g.setColor(Color.black);
        g.fillOval(140,67,3,3);
        g.fillOval(155,67,3,3);
        // 尾巴
        g.setColor(Color.blue);
        g.drawOval(160,240,30,30);
        g.drawLine(150,240,160,260);
        g.drawArc(150,210,60,60,0,-110);
    }
}
