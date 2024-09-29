package qqserver.service;

import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务端
 * 监听9999端口,等待客户端连接,并保持通讯
 */
public class QQServer {
    private ServerSocket serverSocket = null;
    private ServerNewsThread serverNewsThread = new ServerNewsThread();
    // 创建集合存放合法用户, ConcurrentHashMap 线程安全的 HashMap
    private static ConcurrentHashMap<String, User> validUser = new ConcurrentHashMap<>();
    // 离线消息
    private static ConcurrentHashMap<String, ArrayList<Message>> offLineMessage = new ConcurrentHashMap<>();

    static { // 静态代码块初始化 validUser
        validUser.put("100", new User("100", "123456"));
        validUser.put("200", new User("200", "123456"));
        validUser.put("300", new User("300", "123456"));
        validUser.put("至尊宝", new User("至尊宝", "123456"));
        validUser.put("紫霞仙子", new User("紫霞仙子", "123456"));
        validUser.put("菩提老祖", new User("菩提老祖", "123456"));
    }

    /**
     * 获取全部离线信息
     *
     * @return
     */
    public static ConcurrentHashMap<String, ArrayList<Message>> getOffLineMessage() {
        return offLineMessage;
    }

    /**
     * 获取全部合法用户
     *
     * @return
     */
    public static ConcurrentHashMap<String, User> getValidUser() {
        return validUser;
    }

    /**
     * 添加离线信息
     *
     * @param message
     */
    public static void addOffLineMessage(Message message) {
        if (offLineMessage.get(message.getReceiver()) == null) {
            ArrayList<Message> messages = new ArrayList<>();
            messages.add(message);
            offLineMessage.put(message.getReceiver(),messages);
        }else {
            ArrayList<Message> messages = offLineMessage.get(message.getReceiver());
            messages.add(message);
        }
    }

    /**
     * 验证收信人用户
     *
     * @param uid
     * @return
     */
    public static int checkOnline(String uid) {
        User user = validUser.get(uid);
        if (user == null) { // 不存在
            return -1;
        }
        if (ManageServerConnectClientThreads.getServerConnectClientThread(uid) == null) { // 未登录
            return 1;
        }
        return 0;
    }

    public void sendOfflineMessage(String uid) throws IOException {
        ConcurrentHashMap.KeySetView<String, ArrayList<Message>> receivers = offLineMessage.keySet();
        Iterator<String> iterator = receivers.iterator();
        while (iterator.hasNext()) {
            String receiver = iterator.next();
            if (receiver.equals(uid)) {
                System.out.println(uid + " 用户上线了,给他发送离线消息");
                ArrayList<Message> messages = offLineMessage.get(receiver);
                for (int i = 0; i < messages.size(); i++) {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageServerConnectClientThreads.getSocketOutputStream(receiver));
                    objectOutputStream.writeObject(messages.get(i));
                }
                iterator.remove();
            }
        }
    }

    /**
     * 验证用户合法性
     *
     * @param uid
     * @param passwd
     * @return
     */
    private boolean checkUser(String uid, String passwd) {
        User user = validUser.get(uid);
        if (user == null) {
            System.out.println("用户不存在");
            return false;
        }
        if (!user.getPasswd().equals(passwd)) {
            System.out.println("密码错误");
            return false;
        }
        if (ManageServerConnectClientThreads.getServerConnectClientThread(user.getUid()) != null) {
            System.out.println("该用户已登录");
            return false;
        }
        return true;
    }

    public QQServer() {
        try {
            serverNewsThread.start();
            System.out.println("服务端在9999端口监听");
            serverSocket = new ServerSocket(9999); // 端口可以写在配置文件中
            while (true) { // 循环监听,当和某个客户端建立连接后,会继续监听
                Socket socket = serverSocket.accept();
                // 读取客户端发送的 User
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                User user = (User) objectInputStream.readObject();
                // 准备一个 Message 和 输出流
                Message message = new Message();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                // 应在数据库验证用户
                if (checkUser(user.getUid(), user.getPasswd())) { // 验证合法用户
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    objectOutputStream.writeObject(message);
                    // 创建线程,和客户端保持通讯
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(user.getUid(), socket);
                    serverConnectClientThread.start();
                    // 线程加入集合管理
                    ManageServerConnectClientThreads.addServerConnectClientThread(user.getUid(), serverConnectClientThread);

                    // 检测离线消息
                    sendOfflineMessage(user.getUid());

                } else { // 登录失败
                    System.out.println("用户 id = " + user.getUid() + " ,passwd = " + user.getPasswd() + ",尝试登录失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    objectOutputStream.writeObject(message);
                    socket.close();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 服务端退出了循环,不再监听,关闭资源
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
