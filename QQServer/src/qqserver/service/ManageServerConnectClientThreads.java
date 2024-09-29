package qqserver.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理服务器线程
 */
public class ManageServerConnectClientThreads {
    private static ConcurrentHashMap<String, ServerConnectClientThread> hashMap = new ConcurrentHashMap<>();

    /**
     * 添加线程
     *
     * @param uid
     * @param serverConnectClientThread
     */
    public static void addServerConnectClientThread(String uid, ServerConnectClientThread serverConnectClientThread) {
        hashMap.put(uid, serverConnectClientThread);
    }

    /**
     * 获取线程
     *
     * @param uid
     * @return
     */
    public static ServerConnectClientThread getServerConnectClientThread(String uid) {
        return hashMap.get(uid);
    }

    /**
     * 获取输出流
     * @param uid
     * @return
     * @throws IOException
     */
    public synchronized static OutputStream getSocketOutputStream(String uid) throws IOException {
        return hashMap.get(uid).getSocket().getOutputStream();
    }

    /**
     * 移除已退出的线程
     * @param uid
     */
    public static void removeServerConnectClientThread(String uid) {
        hashMap.remove(uid);
    }

    /**
     * 获取在线列表
     *
     * @return
     */
    public static String getOnlineUserList() {
        StringBuffer onlineUserList = new StringBuffer();
        Set<String> keySet = hashMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String uid = iterator.next();
            onlineUserList.append(uid + " ");
        }
        return new String(onlineUserList);
    }
}
