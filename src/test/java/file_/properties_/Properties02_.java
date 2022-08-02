package file_.properties_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/8 16:36
 */
public class Properties02_ {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("charset","utf-8");
        properties.setProperty("user","汤姆"); //存储的是unicode码值
        properties.setProperty("pwd","123456");

        properties.store(new FileOutputStream("src\\test\\mysql2.properties"),null);
        System.out.println("文件配置成功");
    }
}
