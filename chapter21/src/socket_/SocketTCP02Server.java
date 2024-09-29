package socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器监听中...");

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.print(new String(buf,0,readLen));
        }
        System.out.println("服务器接收完毕");

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());

        // 写入结束标记
        socket.shutdownOutput();
        System.out.println("服务器回复完毕");

        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器退出");
    }
}
