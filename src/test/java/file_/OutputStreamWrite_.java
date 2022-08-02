package file_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/8 15:40
 */
public class OutputStreamWrite_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\softwares\\11.txt";
        String charset = "utf-8";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charset);
        osw.write("韩顺平教育");
        System.out.println("按照"+charset+"保存文件成功~");
        osw.close();
    }
}
