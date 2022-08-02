package file_.object;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/8 11:29
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "E:\\softwares\\data.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读写顺序要一致
        System.out.println(ois.readInt());// int ->Integer (实现了Serializable)
        System.out.println(ois.readBoolean()); //boolean  ->Boolean (实现了Serializable)
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object o = ois.readObject();
        System.out.println("运行类型："+o.getClass());
        System.out.println("dog信息"+o);

        ois.close();
        System.out.println("反序列化后的数据读取完毕~~");
    }

    @Test
    public void test(){
        String s = "123ad.4a6";
        System.out.println(s);
        System.out.println(s.lastIndexOf('.'));
        String substring = s.substring(s.lastIndexOf('.'));
        System.out.println(substring);
        System.out.println(s.substring(5));
        System.out.println(s.substring(0,5));
    }
}
