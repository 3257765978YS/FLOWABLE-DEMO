package SingletonPattern;

/**
 * @author : 杨帅
 * @description: 懒汉式（线程不安全）
 * 可能实例化了两个User_2对象
 * @date： 2021/9/13 14:21
 */
public class User_2 {
    private static User_2 user;
    private String name;
    public static int n1 = 999;

    private User_2(String name) {
        System.out.println("构造器被调用...");
        this.name = name;
    }

    public static User_2 getUser() {
        if (user == null) {
            user = new User_2("小红");
        }
        return user;
    }

    @Override
    public String toString() {
        return "User_2{" +
                "name='" + name + '\'' +
                '}';
    }
}
