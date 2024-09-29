package homework;

import update.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在9999端口监听中...");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        String fileName = StreamUtils.streamToString(inputStream) + ".png";
        System.out.println("收到客户端信息:" + fileName);

        // 确定发送文件名
        String defName = "bg.png";
        String dirPath = "C:\\Users\\teiso\\OneDrive\\桌面\\png素材";
        File resFile = new File(dirPath, fileName);
        if (!resFile.exists()) {
            resFile = new File(dirPath,defName);
            System.out.println("查询文件" + fileName + "不存在,将发送默认文件" + defName);
        }

        // 上传文件
        FileInputStream fileInputStream = new FileInputStream(resFile);
        byte[] data = StreamUtils.streamToByteArray(fileInputStream);

        // 发送文件
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(data);
        socket.shutdownOutput();
        System.out.println("发送文件" + resFile + "结束");

        outputStream.close();
        fileInputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器端退出");
    }
}
