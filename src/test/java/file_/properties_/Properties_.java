package file_.properties_;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/8 16:18
 */
public class Properties_ {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\test\\mysql.properties"));
        properties.list(System.out);

        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名："+user);
        System.out.println("密码："+pwd);

    }


}
