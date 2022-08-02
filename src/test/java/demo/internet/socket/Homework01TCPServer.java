package demo.internet.socket;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/12 10:04
 */
public class Homework01TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端，在8888监听，等待连接..");

        Socket socket = serverSocket.accept();

        System.out.println("服务端socket = "+ socket.getClass());
        BufferedWriter writer = null;

        String s = StreamUtils.streamToString(socket.getInputStream());
        String res ;
        if("name".equals(s.trim())){
            res = "我是nova";
        }else if("hobby".equals(s.trim())){
            res = "编写java程序";
        }else{
            res = "你说啥呢";
        }
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(res);
        writer.newLine();
        writer.flush();
        socket.shutdownOutput();




        writer.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出..");
    }

}
