package demo.internet.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/12 11:13
 */
public class Homework03TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999监听，等待下载...");
        Socket socket = serverSocket.accept();

        String musicName = StreamUtils.streamToString(socket.getInputStream());
        System.out.println("客户端希望下载的文件名="+musicName);
        System.out.println(musicName);

        //创建一个BufferedInputStream对象，获取本地的音乐文件
        BufferedInputStream bis = null;
        if("高山流水".equals(musicName)){
            bis = new BufferedInputStream(new FileInputStream("src\\高山流水.mp3"));
        }else{
            bis = new BufferedInputStream(new FileInputStream("src\\default.mp3"));
        }
        //给客户端发送文件
        BufferedOutputStream bos  = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        bos.write(bytes);
        socket.shutdownOutput();

        bis.close();
        bos.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出...");
    }
}
