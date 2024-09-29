package update;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileCopyClient {
    public static void main(String[] args) throws IOException {
        // socket连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        // 读取磁盘源文件,传给服务器
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        String filePath = "C:\\Users\\teiso\\OneDrive\\桌面\\png素材\\tankGame.jpg";
        FileInputStream fis = new FileInputStream(filePath);


        byte[] bytes = StreamUtils.streamToByteArray(fis);
        bos.write(bytes);
        bos.flush();
        // netstat -an | more 查看端口连接
//        try {
//            Thread.sleep(50000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        socket.shutdownOutput();

        // 接收回复
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        // 关流
        inputStream.close();
        bos.close();
        fis.close();
        socket.close();
        System.out.println("退出客户端");

    }
}
