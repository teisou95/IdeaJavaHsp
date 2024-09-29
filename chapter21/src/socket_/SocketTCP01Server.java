package socket_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * 在本机的9999端口监听,等待连接
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        // ServerSocket 可以通过 accept 返回多个 socket(多并发)
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端在9999端口监听,等待连接...");

        // 有客户端连接时得到一个 socket 对象,如果没有客户端连接 程序会阻塞 等待连接
        Socket socket = serverSocket.accept();
        System.out.println("服务器端socket = " + socket.getClass());

        // 接收信息
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // 关闭流 释放资源
        reader.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器端退出");

    }
}
