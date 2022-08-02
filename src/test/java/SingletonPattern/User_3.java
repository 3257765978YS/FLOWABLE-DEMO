package SingletonPattern;

/**
 * @author : 杨帅
 * @description: 懒汉式（加锁）
 * 这种把锁直接方法上的办法，所有的访问都需要获取锁，导致了资源的浪费
 * @date： 2021/9/13 14:38
 */
public class User_3 {
    private static User_3 user;

    private User_3() {
    }

    public synchronized static User_3 getUser() {
        if (user == null) {
            user = new User_3();
        }
        return user;
    }
}
