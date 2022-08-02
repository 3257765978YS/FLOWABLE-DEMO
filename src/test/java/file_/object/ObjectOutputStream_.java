package file_.object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/8 11:28
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        //序列化后，保存的文件格式，不是纯文本，而是按照他的格式来保存
        String filePath = "E:\\softwares\\data.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        //序列化数据到：E:\softwares\data.dat
        oos.writeInt(100);// int ->Integer (实现了Serializable)
        oos.writeBoolean(true); //boolean  ->Boolean (实现了Serializable)
        oos.writeChar('a');
        oos.writeDouble(9.5);
        oos.writeUTF("杨帅");

        oos.writeObject(new Dog("旺财",2));

        oos.close();
        System.out.println("序列化后的数据保存完毕~~");
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private static String nation;
    private transient String color;
    //序列化后的版本号，提高兼容性
    private static final long serialVersionUID = 1L;


    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
