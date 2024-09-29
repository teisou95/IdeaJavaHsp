package socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello.server".getBytes());

        // 写入结束标记
        socket.shutdownOutput(); // 通知监听窗口 结束输出
        System.out.println("客户端发送完毕");

        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.print(new String(buf,0,readLen));
        }
        System.out.println("客户端接收了回复");

        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
