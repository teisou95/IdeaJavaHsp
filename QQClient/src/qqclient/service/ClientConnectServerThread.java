package qqclient.service;

import qqclient.utils.Utility;
import qqcommon.Message;
import qqcommon.MessageType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * 线程类
 * 维护一个 Socket 对象
 */
public class ClientConnectServerThread extends Thread {
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 线程需要在后台和服务器通讯
        while (true) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject(); // 如果服务器没有发送Message对象,线程会阻塞在此
                // 处理信息

                switch (message.getMesType()){
                    case MessageType.MESSAGE_RETURN_ONLINE_FRIEND: // 服务端返回了在线用户列表
                        // 取出在线用户列表,格式:
                        // uid uid uid
                        String[] onlineUsers = message.getContent().split(" ");
                        System.out.println("\n==========当前在线用户列表=========");
                        for (int i = 0; i < onlineUsers.length; i++) {
                            System.out.println("用户 " + onlineUsers[i]);
                        }
                        break;
                    case MessageType.MESSAGE_SEND_FAIL: // 服务端返回发送信息失败
                        System.out.println("\n" + message.getContent());
                        break;
                    case MessageType.MESSAGE_COMM_MES: // 服务端返回普通信息类型
                        System.out.println("\n" + message.getSendTime() + " 收到了 " + message.getSender() + " 用户的私聊消息:\n\t" + message.getContent());
                        break;
                    case MessageType.MESSAGE_SERVER_NEWS: // 服务器推送新闻
                        System.out.println("\n" + message.getSendTime() + " 收到了服务器推送的新闻:\n\t" + message.getContent());
                        break;
                    case MessageType.MESSAGE_SEND_ALL: // 服务端返回群发消息
                        System.out.println("\n" + message.getSendTime() + " 收到了 " + message.getSender() + " 用户的群发消息:\n\t" + message.getContent());
                        break;
                    case MessageType.MESSAGE_SEND_FILE: // 服务端返回文件
                        String[] split = message.getContent().split("/");
                        String fileName = split[split.length - 1];
                        System.out.println("\n" + message.getSendTime() + " 收到了 " + message.getSender() + " 用户发送的文件:\n\t" + fileName);
                        // 下载文件
                        byte[] data = message.getData();
                        FileOutputStream fileOutputStream = new FileOutputStream("src\\" + fileName);
                        fileOutputStream.write(data);
                        fileOutputStream.close();
                        System.out.println("下载文件成功,保存在" + "src\\" + fileName);
                        break;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
