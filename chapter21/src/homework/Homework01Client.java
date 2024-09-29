package homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Homework01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("172.20.10.3"), 7777);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        sendMes(reader, writer);


        reader.close();
        writer.close();
        socket.close();
        System.out.println("客户端退出");
    }

    /**
     * 发送信息
     *
     * @param reader 输入流
     * @param writer 输出流
     * @throws IOException
     */
    public static void sendMes(BufferedReader reader, BufferedWriter writer) throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入发送内容");
            String question = scanner.next();
            if ("退出".equals(question)) return;

            writer.write(question);
            writer.newLine();
            writer.flush();

            String line = reader.readLine();
            System.out.println(line);
        }
    }
}
