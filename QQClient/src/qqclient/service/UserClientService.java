package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

import java.io.*;
import java.net.Socket;

/**
 * 完成用户登陆验证 和 用户注册 等功能
 */
public class UserClientService {
    private User user = new User(); // 可能在其他地方使用 user 信息
    private Socket socket = null;

    /**
     * 根据用户名和密码到服务器验证该用户是否合法
     *
     * @param uid    待验证的用户名
     * @param passwd 待验证的密码
     * @return 服务器返回验证通过(true)或失败(false)
     */
    public boolean checkUser(String uid, String passwd) throws IOException, ClassNotFoundException {
        boolean checkRes = false;
        //
        user.setUid(uid);
        user.setPasswd(passwd);
        // 连接服务器,发送 User 对象
        socket = new Socket("127.0.0.1", 9999);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(user);

        // 读取从服务器回复的 Message 对象
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Message message = (Message) objectInputStream.readObject();
        // 判断是否验证通过
        if (MessageType.MESSAGE_LOGIN_SUCCEED.equals(message.getMesType())) { // 验证通过
            // 创建线程类 ClientConnectServerThread
            ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
            // 启动线程维护 socket
            clientConnectServerThread.start();
            // 为了客户端的扩展,将线程放入集合中管理
            ManageClientConnectServerThreads.addClientConnectServerThread(uid, clientConnectServerThread);
            //
            checkRes = true;
        } else { // 验证失败
            // 关闭 socket
            socket.close();
        }
        return checkRes;
    }

    /**
     * 向服务端请求在线列表
     *
     * @throws IOException
     */
    public void onlineFriendList() throws IOException {
        // 发送一个Message,类型MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(user.getUid());

        // 发送信息给服务器
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(message);
    }

    /**
     * 退出客户端,并给服务端发送退出请求
     *
     * @throws IOException
     */
    public void logout() throws IOException {
        // 发送一个 Message ,类型MESSAGE_CLIENT_EXIT
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(user.getUid());

        // 发送信息给服务器
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(message);
        System.out.println(user.getUid() + " 用户退出了系统");
        System.exit(0); // 结束客户端进程
    }
}
