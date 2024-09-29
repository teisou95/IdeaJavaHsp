package update;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileCopyServer {
    public static void main(String[] args) throws IOException {
        // 监听端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器监听中...");
        Socket socket = serverSocket.accept();

        // 接收客户端数据,保存文件
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        String saveFilePath = "src\\111.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(saveFilePath));
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        bos.write(bytes);
        bos.flush();

        // 回复客户端
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
        bw.flush();
        socket.shutdownOutput();

        //
        bis.close();
        bw.close();
        bos.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器端退出");
    }
}
