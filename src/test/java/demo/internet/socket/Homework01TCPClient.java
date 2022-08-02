package demo.internet.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/12 10:04
 */
public class Homework01TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端socket返回="+socket.getClass());

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Scanner myScanner = new Scanner(System.in);
        BufferedReader reader = null;

        System.out.println("请输入你要发送的字符：");
        String next = myScanner.next();
        writer.write(next.trim());
        writer.flush();
        socket.shutdownOutput();

        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(reader.readLine());


        writer.close();
        reader.close();
        socket.close();
        System.out.println("客户端退出..");
    }
}
