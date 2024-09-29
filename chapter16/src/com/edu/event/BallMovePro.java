package com.edu.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 键盘监听 让小球动起来
 */
public class BallMovePro extends JFrame {
    static BallPanelPro ballPanelPro = null;

    public static void main(String[] args) {
        BallMovePro ballMovePro = new BallMovePro();
    }

    public BallMovePro() {
        ballPanelPro = new BallPanelPro();
        this.add(ballPanelPro);
        this.setSize(800, 600);
        this.addKeyListener(ballPanelPro); // 窗口注册 键盘监听接口,接听键盘事件(面板发生的)
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

// KeyListener 键盘监听接口,监听键盘事件
class BallPanelPro extends JPanel implements KeyListener {
    private int x = 100;
    private int y = 100;
    private Color color = Color.white;
    private int size = 50;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,800,600);
        g.setColor(color);
        g.fillOval(x, y, size, size);
        g.setColor(Color.white);
        g.setFont(new Font("宋体", Font.PLAIN, 20));
        String info = String.format("小球信息:X = %d, Y = %d, size = %d", x, y, size);
        g.drawString(info, x - 20, y - 20);
    }

    // repaint 不需要重写
//    @Override
//    public void repaint(Rectangle r) {
//        super.repaint(r);
//    }

    // 有字符输出时,触发方法(有些键是没有字符输出的,比如上下左右键)
    @Override
    public void keyTyped(KeyEvent e) {
    }

    // 某个键按下去时,触发方法
    @Override
    public void keyPressed(KeyEvent e) { // e :事件对象
        System.out.println(e.getKeyChar() + "字符被按下");
        switch (Character.toUpperCase(e.getKeyChar())) {
            case 'W':
                y -= 5;
                if (y < 0) y = 0;
                break;
            case 'A':
                x -= 5;
                if (x < 0) x = 0;
                break;
            case 'S':
                y += 5;
                if (y > 600 - size) y = 600 - size;
                break;
            case 'D':
                x += 5;
                if (x > 800 - size) x = 800 - size;
                break;
            case 'Y': // 变黄色
                color = Color.yellow;
                break;
            case 'R': // 变红色
                color = Color.red;
                break;
            case '1': // 变大
                size += 10;
                if (size > 600) size = 600; // 还需要验证边界
                if (x > 800 - size) size -= 10;
                if (y > 600 -size) size -= 10;
                break;
            case '0': //变小
                size -= 10;
                if (size < 0) size = 0;
                break;
            default:
                break;
        }
        repaint(); // 重绘
    }

    // 某个键松开时,触发方法
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
