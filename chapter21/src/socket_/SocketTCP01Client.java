package socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999); // 连接本机 9999 端口号
        System.out.println("客户端socket = " + socket.getClass());

        // 得到和 socket 对象关联的 输出流
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("hello,server哈哈哈\n大可靠king\n&%^");

        // 关闭流 释放资源
        writer.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
