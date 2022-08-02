package demo.internet.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/9 10:51
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端socket返回="+socket.getClass());

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());
        socket.shutdownOutput();

        byte[] bytes = new byte[1024];
        int readLen = 0;
        InputStream inputStream = socket.getInputStream();
        while((readLen = inputStream.read(bytes)) !=-1){
            System.out.println("接收到客户端的回送消息："+new String(bytes,0,readLen));
        }

        outputStream.close();
        socket.close();
        inputStream.close();
        System.out.println("客户端退出..");
    }
}
