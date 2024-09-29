package com.edu.draw;

import javax.swing.*;
import java.awt.*;

/**
 * 0571
 * java 绘图
 * 坐标系:原点位于左上角,(x,y)代表 X 轴和 Y 轴坐标的像素点
 * 像素点组成显示分辨率,如2560*1600分辨率,代表有2500*1600个像素点
 *
 * 系统监听机制:
 *
 */
public class DrawCircle extends JFrame { // JFrame 对应一个 窗口(画框)
    // 定义一个面板,嵌入窗口
    private MyPanel myPanel = null; // 私有属性 面板
    public static void main(String[] args) {
        DrawCircle drawCircle = new DrawCircle();
        // 也可以在main 方法设置,添加
//        drawCircle.setSize(600,400);
//        drawCircle.setVisible(true);
//        drawCircle.add(new MyPanel());



    }

    // 构造器方式
    public DrawCircle() {
        // 初始化面板
        myPanel = new MyPanel();
        // 将面板嵌入窗口
        this.add(myPanel);
        // 设置窗口大小
        this.setSize(800,600);
        // 让窗口可以显示
        this.setVisible(true); // paint 第一次被调用
        // 关闭窗口并不会自动结束程序运行,需要设置默认退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// 定义面板类,继承JPanel类 => 继承JComponent => 继承 Container => 继承 Component
// Component 类型提供两个和绘图相关最重要的方法
// paint(Graphics g):绘制组件外观
// repaint:刷新组件外观
/*
    paint被系统调用的情况:
    1.组件第一次在屏幕显示时
    2.窗口收起再打开时(最小化再最大化)
    3.窗口的大小发生变化时
    4.repaint 方法被调用时
 */
// 后面图形就在面板上画
class MyPanel extends JPanel {
    private static int paintUseCount = 0;

    /**
     * MyPanel 对象是一个画板
     *
     * @param g Graphics g 是一支画笔
     *          Graphics 类提供了很多绘图的方法
     */
    @Override
    public void paint(Graphics g) { // 重写 绘图方法
        super.paint(g); // 不能去掉,一定要保留,调用父类方法完成初始化
        // 画一个圆
        /*
            x,y 椭圆左上角坐标(指用将椭圆框起来的矩形的左上角)
            width,height 椭圆宽度/高度
         */
        g.drawOval(100, 100, 150, 150);
        g.drawLine(20,150,65,32); // 直线
        g.drawOval(120,10,60,35); // 椭圆
        g.setColor(Color.RED); // 设置画笔颜色
        g.drawRect(30,30,100,20); //矩形
        g.setColor(Color.BLUE); // 更改画笔颜色
        g.fillRect(30,55,100,20); // 填充矩形
        g.setColor(Color.gray);
        g.fillOval(300,45,120,20); // 填充椭圆
        // 获取图片资源
        // 图片要放在 当前project.out根目录 / 斜杠代表在项目根目录查找文件
        // 以下几种方式都可以

        // *******注意!!!!网上下载的图片直接改格式不行!!!!!!!
        // *******注意!!!!网上下载的图片直接改格式不行!!!!!!!
        // *******注意!!!!网上下载的图片直接改格式不行!!!!!!!
        // *******注意!!!!java不支持webp格式图片!!!!!!!
        // *******注意!!!!java不支持webp格式图片!!!!!!!
        // *******注意!!!!java不支持webp格式图片!!!!!!!

//        Image image = Toolkit.getDefaultToolkit().getImage("D:/IdeaJavaProjects/chapter16/out/production/chapter16/bg.png");
//        Image image = Toolkit.getDefaultToolkit().getImage("D:\\IdeaJavaProjects\\chapter16\\out\\production\\chapter16\\bg.png");
//        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bg.png"));
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tankGame.jpg"));
        System.out.println(image);
//        g.drawImage(image,100,200 ,600,450,this);
        // 图片会覆盖之前绘画的内容(处于相同像素范围的部分)
        // 图片大小可以不设置,按图片默认大小处理
        // 图片宽高如果设置与默认大小比例不同,会变形

        // 设置字体
        g.setColor(Color.RED);
        g.setFont(new Font("宋体",Font.PLAIN,100));
        g.drawString("霓虹灯",300,300); // x y 是 String 左下角的坐标
        g.setColor(Color.BLUE);
        g.setFont(new Font("隶书",Font.BOLD,50));
        g.drawString("哈哈",500,400);

        System.out.println("paint方法被自动调用了" + ++paintUseCount);
    }


}
