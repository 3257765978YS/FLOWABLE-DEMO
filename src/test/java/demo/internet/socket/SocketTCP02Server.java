package demo.internet.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/9 11:24
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999监听，等待连接..");

        Socket socket = serverSocket.accept();

        System.out.println("服务端socket = "+ socket.getClass());

        String line;
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("hello,clint");
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();


        br.close();
        bw.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出..");
    }

}
