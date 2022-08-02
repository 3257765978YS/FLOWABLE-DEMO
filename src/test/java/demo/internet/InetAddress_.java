package demo.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/9 10:20
 */
public class InetAddress_ {
    public static void main(String[] args) throws UnknownHostException {
        //1.获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        //2.根据指定主机名获取InetAddress对象
        InetAddress host1 = InetAddress.getByName("DESKTOP-6VJS5SI");
        System.out.println(host1);
        //3.根据域名返回InetAddress对象，比如www.baidu.com
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);

        //4.根据InetAddress对象获取对应的地址
        String hostAddress = host2.getHostAddress();
        System.out.println(hostAddress);
        //5.通过InetAddress对象获取对应的主机名
        String hostName = host2.getHostName();
        System.out.println(hostName);
    }
}
