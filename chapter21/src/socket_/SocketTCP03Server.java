package socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器监听中...");

        Socket socket = serverSocket.accept();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
//        line = reader.readLine(); // 当对方使用 newLine 做结束标记时
//        System.out.println(line);
        System.out.println("服务器接收完毕");

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("hello,client");

        // 必须刷新
        writer.flush();

        // 写入结束标记
        socket.shutdownOutput();
        System.out.println("服务器回复完毕");

        writer.close();
        reader.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器退出");
    }
}
