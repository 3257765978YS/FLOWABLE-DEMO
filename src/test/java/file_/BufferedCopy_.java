package file_;

import org.junit.Test;

import java.io.*;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/8 10:57
 */
public class BufferedCopy_ {
    public static void main(String[] args) {
        String srcPath = "E:\\softwares\\story.txt";
        String destPath = "E:\\softwares\\story2.txt";

        String line ;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(srcPath));
            writer = new BufferedWriter(new FileWriter(destPath));
            while ((line = reader.readLine())!=null){
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void BufferedCopy02(){
        String srcPath = "E:\\softwares\\11.txt";
        String destPath = "E:\\softwares\\11copy.txt";

        int data ;
        byte[] bytes = new byte[1024];
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcPath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destPath));
            while ((data = bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedInputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
