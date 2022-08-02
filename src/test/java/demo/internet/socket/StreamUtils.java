package demo.internet.socket;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/9 13:52
 */
public class StreamUtils {

    /**
     * 将输入流转换成byte[]，即可以把文件的内容  读入到byte[]
     * @param is
     * @return
     * @throws Exception
     */
    public static byte[] streamToByteArray(InputStream is) throws Exception{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();//创建输出流对象
        byte[] b = new byte[1024];
        int len;
        while((len = is.read(b))!=-1){
            bos.write(b,0,len);
        }
        byte[] array = bos.toByteArray();
        bos.close();
        return array;
    }

    /**
     * 将InputStream转换成String
     * @param is
     * @return
     * @throws Exception
     */
    public static String streamToString(InputStream is) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;
        while((line = reader.readLine())!=null){
            builder.append(line);
        }
        return builder.toString();
    }
}
