package demo.internet.socket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author : 杨帅
 * @description: 发送端B
 * @date： 2021/10/12 09:18
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //创建DatagramSocket对象，准备在9998接收数据
        DatagramSocket socket = new DatagramSocket(9998);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入你的问题：");
        String next = myScanner.next();
        //将需要发送的数据，封装到DatagramPacket对象
        byte[] data = next.getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.1.218"), 9999);
        socket.send(packet);



        //构建一个DatagramPacket对象，准备包装接收到的数据
        //注意，一个数据包不超过64K
        byte[] buf = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(buf, buf.length);
        //调用接收方法  将网络传输的DatagramPacket对象，填充到packet对象当中去
        //此时socket的receive()方法处于监听状态，有数据就填充，没有则阻塞(一直等待不结束)
        socket.receive(packet2);

        //将packet进行拆包，取出数据，显示
        byte[] data2 = packet2.getData(); //接收到数据
        int length = packet2.getLength();//实际接收数据的长度
        String s = new String(data2, 0, length);
        System.out.println(s);

        //关闭资源
        socket.close();

    }
}
