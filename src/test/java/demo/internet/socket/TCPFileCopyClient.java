package demo.internet.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/9 13:16
 */
public class TCPFileCopyClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端socket返回="+socket.getClass());
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("e:\\softwares\\1.png"));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("e:\\softwares\\破解版_Xshell.zip"));
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bos.flush();
        socket.shutdownOutput();


        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println("客户端收到来自服务端的回推消息："+s);
//        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//        String line;
//        while ((line =br.readLine())!=null){
//            System.out.println("客户端收到来自服务端的回推消息："+line);
//        }

        bos.close();
        bis.close();
        inputStream.close();
        socket.close();
        System.out.println("客户端退出...");

    }
}
