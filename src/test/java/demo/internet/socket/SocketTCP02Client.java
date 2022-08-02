package demo.internet.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/9 11:24
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端socket返回="+socket.getClass());

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("hello,server");
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();

        String line;
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        while((line = br.readLine()) !=null){
            System.out.println("接收到客户端的回送消息："+line);
        }

        br.close();
        socket.close();
        bw.close();
        System.out.println("客户端退出..");
    }
}
