package homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("监听7777中...");
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        backMes(reader, writer);

        writer.close();
        reader.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器端退出");
    }

    /**
     * 按接收信息回复消息
     *
     * @param reader 输入流
     * @param writer 输出流
     * @throws IOException
     */
    public static void backMes(BufferedReader reader, BufferedWriter writer) throws IOException {
        String question;
        String answer = "";
        while ((question = reader.readLine()) != null) {
            System.out.println(question);

            if ("name".equals(question)) {
                answer = "我是nova";
            } else if ("hobby".equals(question)) {
                answer = "编写java程序";
            } else {
                answer = "你说啥呢";
            }
            writer.write(answer);
            writer.newLine();
            writer.flush();
        }
    }
}
