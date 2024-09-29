package qqserver.service;

import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;
import utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务器推送新闻独立线程
 */
public class ServerNewsThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("请输入要推送的新闻(exit 表示退出推送服务)");
            String news = Utility.readString(200);
            // 构建信息
            if ("exit".equals(news)) break;
            Message message = new Message();
            message.setContent(news);
            message.setMesType(MessageType.MESSAGE_SERVER_NEWS);
            message.setSendTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒")));
            // 发送信息给全部在线用户
            ConcurrentHashMap.KeySetView<String, User> allUid = QQServer.getValidUser().keySet();
            Iterator<String> iterator = allUid.iterator();
            while (iterator.hasNext()) {
                String uid = iterator.next();
                message.setReceiver(uid);
                if (QQServer.checkOnline(uid) == 1) {
                    // 存入数据库
                    System.out.println(uid + " 用户未登录,离线消息存入数据库");
                    QQServer.addOffLineMessage(message);
                } else if (QQServer.checkOnline(uid) == 0) {
                    ObjectOutputStream objectOutputStream = null;
                    try {
                        objectOutputStream = new ObjectOutputStream(ManageServerConnectClientThreads.getSocketOutputStream(uid));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        objectOutputStream.writeObject(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
