package qqframe;

import qqserver.service.QQServer;

/**
 * 创建QQServer对象,启动后台服务
 */
public class QQFrame {
    public static void main(String[] args) {
        QQServer qqServer = new QQServer();
        System.exit(0);
    }
}
