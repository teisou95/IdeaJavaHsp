package qqcommon;

/**
 * 消息类型
 */
public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED = "1"; // 表示登陆成功
    String MESSAGE_LOGIN_FAIL = "2"; // 表示登陆失败
    String MESSAGE_COMM_MES = "3"; // 普通信息对象
    String MESSAGE_GET_ONLINE_FRIEND = "4"; // 要求返回在线列表
    String MESSAGE_RETURN_ONLINE_FRIEND = "5"; // 返回在线列表
    String MESSAGE_CLIENT_EXIT = "6"; // 客户端请求退出
    String MESSAGE_SEND_FAIL = "7"; // 发送信息失败
    String MESSAGE_SEND_ALL = "8"; // 群发消息
    String MESSAGE_SEND_FILE = "9"; // 发送文件
    String MESSAGE_SERVER_NEWS = "10"; // 服务器推送新闻
}
