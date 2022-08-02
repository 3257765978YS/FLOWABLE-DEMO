package demo.internet.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author : 杨帅
 * @description: UDP接收端
 * @date： 2021/10/12 09:18
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket对象，准备接收9999端口数据(接收源)
        DatagramSocket socket = new DatagramSocket(9999);
        //构建一个DatagramPacket对象，准备包装接收到的数据
        //注意，一个数据包不超过64K
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //调用接收方法  将网络传输的DatagramPacket对象，填充到packet对象当中去
        //此时socket的receive()方法处于监听状态，有数据就填充，没有则阻塞(一直等待不结束)
        System.out.println("等待对方问问题..");
        socket.receive(packet);

        //将packet进行拆包，取出数据，显示
        byte[] data = packet.getData(); //接收到数据
        int length = packet.getLength();//实际接收数据的长度
        String s = new String(data, 0, length);
        String answer;
        if("四大名著是哪些".equals(s)){
            answer = "《红楼梦》《水浒传》《三国演义》《西游记》";
        }else{
            answer = "what?";
        }



        //回复消息
        byte[] data2 = answer.getBytes();
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length, InetAddress.getByName("192.168.1.218"), 9998);
        socket.send(packet2);

        //关闭资源
        socket.close();

    }
}
