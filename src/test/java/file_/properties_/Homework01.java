package file_.properties_;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/8 16:46
 */
public class Homework01 {
    public static void main(String[] args) {

    }
    @Test
    public void homework1() throws IOException {
        String filePath = "e:\\softwares\\mytemp";
        File file = new File(filePath);
        if(!file.exists()) {
            file.mkdirs();
        }
        String fileName = "hello.txt";
        File file1 = new File(file,fileName);
        if(file1.exists()){
            System.out.println("该文件已存在，无需创建~");
        }else{
            file1.createNewFile();
        }

    }
    @Test
    public void homework2() throws IOException {
        String filePath = "e:\\softwares\\11copy.txt";
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"gbk"));
        while((line=reader.readLine())!=null){
            System.out.println(line +'。');
        }
        reader.close();
    }
    @Test
    public void homework3(){
        Properties properties = new Properties();
        properties.setProperty("name","tom");
        properties.setProperty("age","5");
        properties.setProperty("color","red");

        Dog dog = new Dog(properties.getProperty("name"), Integer.parseInt(properties.getProperty("age")), properties.getProperty("color"));
        System.out.println(dog);
    }
}
class Dog{
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
