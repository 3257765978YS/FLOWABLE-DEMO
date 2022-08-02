package file_;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/8 09:18
 */
public class FileCopy {
    public static void main(String[] args) {

    }

    @Test
    public void copy(){
        String srcPath = "E:\\demo\\demo.txt";
        String destPath = "E:\\demo\\demo2.txt";
        byte[] buf = new byte[1024];
        int resData = 0;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);
            while ((resData = fileInputStream.read(buf))!=-1){
                fileOutputStream.write(buf,0,resData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
