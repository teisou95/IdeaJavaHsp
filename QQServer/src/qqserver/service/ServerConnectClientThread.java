package qqserver.service;

import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class ServerConnectClientThread extends Thread {
    private String uid; // 连接到服务器的用户id
    private Socket socket;

    public ServerConnectClientThread(String userId, Socket socket) {
        this.uid = userId;
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("服务端线程和客户端" + uid + "保持通讯...");
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();
                // 根据message类型 处理信息
                switch (message.getMesType()) {
                    case MessageType.MESSAGE_GET_ONLINE_FRIEND:
                        System.out.println(message.getSender() + " 用户请求在线列表");
                        // 构建信息
                        Message message1 = new Message();
                        message1.setMesType(MessageType.MESSAGE_RETURN_ONLINE_FRIEND);
                        message1.setContent(ManageServerConnectClientThreads.getOnlineUserList());
                        message1.setReceiver(message.getSender());
                        // 发送信息返回给客户端
                        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream
                                (ManageServerConnectClientThreads.getSocketOutputStream(message1.getReceiver()));
                        objectOutputStream1.writeObject(message1);
                        break;
                    case MessageType.MESSAGE_COMM_MES:
                        System.out.println(message.getSender() + " 用户请求向 " + message.getReceiver() + " 用户发信息");
                        Message message2 = new Message();
                        // 验证收信用户
                        if (QQServer.checkOnline(message.getReceiver()) == -1) { // uid不存在
                            // 构建信息
                            message2.setMesType(MessageType.MESSAGE_SEND_FAIL);
                            message2.setContent("用户不存在,发送信息失败");
                            message2.setReceiver(message.getSender());
                        } else if (QQServer.checkOnline(message.getReceiver()) == 1) { // uid未登录
                            // 存入数据库
                            System.out.println("用户未登录,离线消息存入数据库");
                            QQServer.addOffLineMessage(message);
                            break;
                        } else { // 正常发送
                            // 构建信息
                            message2 = message;
                        }
                        // 发送信息给目标用户
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream
                                (ManageServerConnectClientThreads.getSocketOutputStream(message2.getReceiver()));
                        objectOutputStream2.writeObject(message2);
                        break;
                    case MessageType.MESSAGE_SEND_ALL:
                        System.out.println(message.getSender() + " 用户请求向 全部在线 用户群发信息");
                        // 发送信息给全部用户
                        ConcurrentHashMap.KeySetView<String, User> allUid = QQServer.getValidUser().keySet();
                        for (String uid :allUid) {
                            if (uid.equals(message.getSender())) continue; // 跳过发信人
                            message.setReceiver(uid);
                            if (QQServer.checkOnline(uid) == 1){
                                System.out.println(uid + " 用户未登录,存入离线消息数据库");
                                QQServer.addOffLineMessage(message);
                                continue;
                            }
                            ObjectOutputStream objectOutputStream3 = new ObjectOutputStream
                                    (ManageServerConnectClientThreads.getSocketOutputStream(message.getReceiver()));
                            objectOutputStream3.writeObject(message);
                        }
                        break;
                    case MessageType.MESSAGE_SEND_FILE:
                        System.out.println(message.getSender() + " 用户请求向 " + message.getReceiver() + " 用户发文件");
                        Message message3 = new Message();
                        // 验证收信用户
                        if (QQServer.checkOnline(message.getReceiver()) == -1) {//uid不存在
                            // 构建信息
                            message3.setMesType(MessageType.MESSAGE_SEND_FAIL);
                            message3.setContent("用户不存在,发送文件失败");
                            message3.setReceiver(message.getSender());
                        } else if (QQServer.checkOnline(message.getReceiver()) == 1) { // uid未登录
                            System.out.println("用户未登录,存入离线消息数据库");
                            QQServer.addOffLineMessage(message);
                            break;
                        } else {
                            // 构建信息
                            message3 = message;
                        }
                        // 发送信息给目标用户
                        ObjectOutputStream objectOutputStream4 = new ObjectOutputStream
                                (ManageServerConnectClientThreads.getSocketOutputStream(message3.getReceiver()));
                        objectOutputStream4.writeObject(message3);
                        break;
                    case MessageType.MESSAGE_CLIENT_EXIT:
                        System.out.println(message.getSender() + " 用户请求退出");
                        // 删除客户端对应线程,关闭socket,退出线程
                        ManageServerConnectClientThreads.removeServerConnectClientThread(message.getSender());
                        socket.close();
                        return;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public String getUid() {
        return uid;
    }
}
