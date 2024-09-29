package UDP_;

import java.io.IOException;
import java.net.*;

public class UDP_Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(7777);
        DatagramPacket packet = new DatagramPacket("hello,".getBytes(), 6, InetAddress.getLocalHost(), 8888);
        datagramSocket.send(packet);
    }
}
