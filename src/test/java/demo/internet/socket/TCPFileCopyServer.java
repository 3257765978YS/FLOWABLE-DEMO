package demo.internet.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/9 13:16
 */
public class TCPFileCopyServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888监听，等待连接...");
        Socket socket = serverSocket.accept();
        System.out.println("服务端socket = "+ socket.getClass());


        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
//        BufferedOutputStream bos  = new BufferedOutputStream(new FileOutputStream("src\\2.png"));
        BufferedOutputStream bos  = new BufferedOutputStream(new FileOutputStream("src\\破解版_Xshell2.zip"));
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        bos.write(bytes);
        bos.flush();


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();


        bw.close();
        bis.close();
        bos.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出...");
    }
}
