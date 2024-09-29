package qqcommon;

import java.io.Serializable;

/**
 * 客户端与服务器端通讯的消息对象
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 2L; //
    private String sender; // 发送方
    private String receiver; // 接收方
    private String content; // 消息内容
    private byte[] data; // 文件字节数组
    private String sendTime; // 发送时间
    private String mesType; // 消息类型,在接口中定义消息类型

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
