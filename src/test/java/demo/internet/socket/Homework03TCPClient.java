package demo.internet.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/12 11:13
 */
public class Homework03TCPClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端socket返回="+socket.getClass());

        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入您要查看的音乐名称：");
        String musicName = myScanner.next();
        //发送文件名
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(musicName.trim());
        writer.flush();
        socket.shutdownOutput();

        //获取从服务端发来的 文件
        String fileName = musicName +".mp3";
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("e:\\softwares\\"+fileName));
        bos.write(bytes);

        bos.close();
        bis.close();
        writer.close();
        socket.close();
        System.out.println("客户端退出...");

    }
}
