package homework;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Homework02UDP_A {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            socket.receive(packet);

            byte[] date;
            String question = new String(packet.getData(), 0, packet.getLength());
            System.out.println(question);
            if ("四大名著是哪些".equals(question)) {
                date = "四大名著是<<红楼梦>>...".getBytes();
            } else {
                date = "what?".getBytes();
            }
            packet = new DatagramPacket(date, date.length, packet.getAddress(), packet.getPort());
            socket.send(packet);

        socket.close();
        System.out.println("A退出");
    }
}
