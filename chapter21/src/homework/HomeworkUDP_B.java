package homework;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HomeworkUDP_B {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8877);

            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入问题");
            String question = scanner.next();
            byte[] data = question.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("172.20.10.3"), 8888);
            socket.send(packet);

            packet = new DatagramPacket(new byte[1024],1024);
            socket.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
        System.out.println("B退出");
    }
}
