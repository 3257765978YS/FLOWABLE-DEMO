package SingletonPattern;

/**
 * @author : 杨帅
 * @description: 饿汉式（线程安全）
 * @date： 2021/9/13 14:15
 */
public class User_1 {
    private String name;
    public static int n1=100;
    private static final User_1 user = new User_1("小明");

    private User_1(String name) {
        System.out.println("调用构造器...");
        this.name = name;
    }

    public static User_1 getUser() {
        System.out.println("完成实例化...");
        return user;
    }

    @Override
    public String toString() {
        return "User_1{" +
                "name='" + name + '\'' +
                '}';
    }
}
