package qqclient.service;

import qqclient.utils.Utility;
import qqcommon.Message;
import qqcommon.MessageType;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 提供和消息相关的服务方法
 */
public class MessageClientService {
    /**
     * 私聊消息
     *
     * @param uid
     * @throws IOException
     */
    public void privateChat(String uid) throws IOException {
        // 发送一个 Message ,类型 MESSAGE_COMM_MES
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSender(uid);
        System.out.print("请输入私聊用户uid:");
        message.setReceiver(Utility.readString(50));
        System.out.print("请输入聊天内容:");
        message.setContent(Utility.readString(100));
        message.setSendTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒")));

        // 发送信息给服务器
        Socket socket = ManageClientConnectServerThreads.getClientConnectServerThread(uid).getSocket();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(message);
    }


    /**
     * 群发消息
     *
     * @param uid
     * @throws IOException
     */
    public void radioChat(String uid) throws IOException {
        // 发送一个 Message ,类型 MESSAGE_SEND_ALL
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_SEND_ALL);
        message.setSender(uid);
        System.out.print("请输入群发消息内容:");
        message.setContent(Utility.readString(100));
        message.setSendTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒")));

        // 发送信息给服务器
        Socket socket = ManageClientConnectServerThreads.getClientConnectServerThread(uid).getSocket();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(message);
    }

    /**
     * 发送文件给指定用户
     *
     * @param uid
     * @throws IOException
     */
    public void fileChat(String uid) throws IOException {
        // 发送一个 Message ,类型 MESSAGE_SEND_FILE
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_SEND_FILE);
        message.setSender(uid);
        message.setSendTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒")));
        System.out.print("请输入发送文件目标用户uid:");
        message.setReceiver(Utility.readString(50));

        // 上传文件 转为字节数组
        System.out.print("请选择要发送的文件:");
        String filePath = Utility.readString(100);
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = fileInputStream.read(buf)) != -1) {
            byteArrayOutputStream.write(buf, 0, readLen);
        }
        byte[] data = byteArrayOutputStream.toByteArray();
        message.setData(data);
        message.setContent(filePath);

        fileInputStream.close();
        byteArrayOutputStream.close();

        // 发送信息给服务器
        Socket socket = ManageClientConnectServerThreads.getClientConnectServerThread(uid).getSocket();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(message);
    }
//    /**
//     * 拒收文件
//     *
//     * @param mes
//     * @throws IOException
//     */
//    public void refuseFile(String uid,Message mes) throws IOException {
//        // 发送一个 Message ,类型 MESSAGE_COMM_MES
//        Message message = new Message();
//        message.setMesType(MessageType.MESSAGE_SEND_FAIL);
//        message.setSender(uid);
//        message.setReceiver(mes.getSender());
//        message.setContent(uid + " 用户拒收了你发送的文件 " + mes.getContent());
//
//        // 发送信息给服务器
//        Socket socket = ManageClientConnectServerThreads.getClientConnectServerThread(uid).getSocket();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//        objectOutputStream.writeObject(message);
//    }
}
