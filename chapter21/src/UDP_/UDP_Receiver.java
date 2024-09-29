package UDP_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP_Receiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        DatagramPacket datagramPacket = new DatagramPacket(new byte[5], 5);
        datagramSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        for (int i = 0; i < data.length; i++) {
            System.out.print((char)data[i]);
        }
        System.out.println();
        System.out.println(datagramPacket.getAddress());
        System.out.println(datagramPacket.getPort());
    }
}
