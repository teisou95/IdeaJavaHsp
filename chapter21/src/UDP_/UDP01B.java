package UDP_;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDP01B {
    public static void main(String[] args) throws IOException {
        // 发送
        DatagramSocket datagramSocket = new DatagramSocket(); // 发送端可以不指定端口,自动分配
        byte[] bytes = "hello,明天吃火锅~".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9999);
        datagramSocket.send(packet);

        //
        DatagramPacket packet1 = new DatagramPacket(new byte[128], 128);
        datagramSocket.receive(packet1); // 等待接收数据

        // 拆包
        String s = new String(packet1.getData(), 0, packet.getLength());
        System.out.println(s);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(packet1.getData())));
//        String s = reader.readLine();
//        System.out.println(s);

        //
        datagramSocket.close();
        System.out.println("B退出");
    }
}
