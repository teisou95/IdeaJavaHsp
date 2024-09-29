package UDP_;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDP01A {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        DatagramPacket packet = new DatagramPacket(new byte[128], 128);
        datagramSocket.receive(packet); // 等待接收数据

        // 拆包
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
//        BufferedReader readr = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(packet.getData())));
//        String s = reader.readLine();
//        System.out.println(s);


        // 回复
        byte[] bytes = "好的,明天见".getBytes();
        datagramSocket.send(new DatagramPacket(bytes,bytes.length,packet.getAddress(),packet.getPort()));
        System.out.println("packet = " + packet.getPort());

        //
        datagramSocket.close();
        System.out.println("A退出");

    }
}
