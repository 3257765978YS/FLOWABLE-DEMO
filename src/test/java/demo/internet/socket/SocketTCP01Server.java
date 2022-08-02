package demo.internet.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/9 10:50
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999监听，等待连接..");

        Socket socket = serverSocket.accept();

        System.out.println("服务端socket = "+ socket.getClass());

        byte[] bytes = new byte[1024];
        int readLen = 0;
        InputStream inputStream = socket.getInputStream();
        while((readLen = inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,readLen));
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,clint".getBytes());
        socket.shutdownOutput();

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出..");

    }
}
