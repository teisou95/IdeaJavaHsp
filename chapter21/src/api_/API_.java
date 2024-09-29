package api_;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress 类
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        // 获取本机 InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost); // 计算机名 + 本机IP地址

        // 根据指定主机名 获取对象
        InetAddress teiSou = InetAddress.getByName("TeiSou");
        System.out.println(teiSou);

        // 根据域名 获取对象,返回 域名 + IP
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu); // www.baidu.com/119.63.197.139

        InetAddress google = InetAddress.getByName("www.google.com");
        System.out.println(google); // www.google.com/142.250.207.100

        // 通过InetAddress 对象反向获取 对应主机ip地址
        String googleHostAddress = google.getHostAddress();
        System.out.println("googleHostAddress = " + googleHostAddress);

        // 获取主机名/域名
        String googleHostName = google.getHostName();
        System.out.println("googleHostName = " + googleHostName);


    }
}
