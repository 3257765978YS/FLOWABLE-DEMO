package file_;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/8 09:54
 */
public class FileWriter_ {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile01(){
        String destPath = "E:\\softwares\\note.txt";
        FileWriter fileWriter = null;
        char[] chars = {'a','b','c'};
        try {
            fileWriter = new FileWriter(destPath);
//            fileWriter.write('c');
//            fileWriter.write(chars);
//            fileWriter.write("杨帅杨帅".toCharArray(),0,1);
            fileWriter.write("杨帅姚奋总");
            fileWriter.write("杨帅姚奋总",0,2);

            System.out.println("操作成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileWriter != null){
                try {
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
