package homework;

import update.StreamUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Homework03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("172.20.10.3",9999);
        OutputStream outputStream = socket.getOutputStream();

        // 发送信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件名");
        String fileName = scanner.next();
        outputStream.write(fileName.getBytes());
        socket.shutdownOutput();
        System.out.println("发送信息结束");

        // 下载文件
        InputStream inputStream = socket.getInputStream();
        byte[] data = StreamUtils.streamToByteArray(inputStream);
        // 保存文件
        String destFilePath = "src\\" + fileName + ".png";
        FileOutputStream fileOutputStream = new FileOutputStream(destFilePath);
        fileOutputStream.write(data);
        System.out.println("保存了文件" + destFilePath);

        fileOutputStream.close();
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");

    }
}
