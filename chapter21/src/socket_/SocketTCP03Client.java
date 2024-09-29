package socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("hello.server");

        // 必须刷新
//        writer.newLine(); // 可以代替 结束标记(对方必须 readLine,且不能循环读取)
        writer.flush();

        // 写入结束标记
        socket.shutdownOutput(); // 通知监听窗口 结束输出
        System.out.println("客户端发送完毕");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("客户端接收了回复");

        reader.close();
        writer.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
