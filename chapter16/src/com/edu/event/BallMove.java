package com.edu.event;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * java事件控制
 * 演示小球通过键盘控制移动
 */
public class BallMove extends JFrame {
    static BallPanel ballPanel = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
        control();
    }

    public BallMove() {
        ballPanel = new BallPanel(new Ball(100, 100, Color.black, 50));
        this.add(ballPanel);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void control() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("WASD 上左下右,P 退出");
        while (true) {
            char c = scanner.next().toUpperCase().charAt(0);
            switch (c) {
                case 'W':
                    ballPanel.getBall().setY(ballPanel.getBall().getY() - 5);
                    ballPanel.repaint();
                    break;
                case 'A':
                    ballPanel.getBall().setX(ballPanel.getBall().getX() - 5);
                    ballPanel.repaint();
                    break;
                case 'S':
                    ballPanel.getBall().setY(ballPanel.getBall().getY() + 5);
                    ballPanel.repaint();
                    break;
                case 'D':
                    ballPanel.getBall().setX(ballPanel.getBall().getX() + 5);
                    ballPanel.repaint();
                    break;
                case 'P':
                    return;
                default:
                    break;
            }

        }

    }
}

class BallPanel extends JPanel {
    private static Ball ball;

    public BallPanel(Ball ball) {
        this.ball = ball;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        moveBall(ball.getX(), ball.getY(), ball.getColor(), ball.getSize(), g);
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    public void moveBall(int x, int y, Color color, int size, Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
}

class Ball {
    private int x;
    private int y;
    private Color color;
    private int size;

    public Ball(int x, int y, Color color, int size) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
