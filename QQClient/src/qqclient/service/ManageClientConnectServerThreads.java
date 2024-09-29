package qqclient.service;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理客户端与服务器通讯线程
 */
public class ManageClientConnectServerThreads {
    // 将多个线程放入一个集合,key 是uid
    private static ConcurrentHashMap<String, ClientConnectServerThread> hashMap = new ConcurrentHashMap<>();

    /**
     * 将某个线程加入到集合
     *
     * @param uid 用户名
     * @param thread 用户通讯线程
     */
    public static void addClientConnectServerThread(String uid, ClientConnectServerThread thread) {
        hashMap.put(uid, thread);
    }

    /**
     * 通过userId 获取 对应线程
     *
     * @param uid 用户名
     * @return 线程
     */
    public static ClientConnectServerThread getClientConnectServerThread(String uid) {
        return hashMap.get(uid);
    }
}
