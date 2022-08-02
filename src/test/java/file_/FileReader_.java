package file_;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.FutureTask;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/8 09:37
 */
public class FileReader_ {
    public static void main(String[] args) {
        String filePath = "E:\\softwares\\11.txt";
        FileReader fileReader =null;
        int data = 0;
        try {
            fileReader = new FileReader(filePath);
            while((data = fileReader.read())!=-1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileReader!=null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }






    @Test
    public void readFile02(){
        String filePath = "E:\\softwares\\11.txt";
        FileReader fileReader =null;
        int data = 0;
        char[] buf = new char[8];
        try {
            fileReader = new FileReader(filePath);
            while((data = fileReader.read(buf))!=-1){
                System.out.print(new String(buf,0,data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileReader!=null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void transferTo(){
        String filePath = "E:\\softwares\\11.txt";
        InputStreamReader ir =null;
        BufferedReader br=null;
        String line ;

        try {
//            ir = new InputStreamReader(new FileInputStream(filePath),"gbk");
//            br = new BufferedReader(ir);
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"gbk"));
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
