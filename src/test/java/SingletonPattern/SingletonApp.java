package SingletonPattern;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/13 14:24
 */
public class SingletonApp {
    public static void main(String[] args) {
        User_1 user1 = User_1.getUser();
        System.out.println(user1);
//        User_2 user2 = User_2.getUser();
//        System.out.println(user2);
//        User_1 user = User_1.getUser();
//        System.out.println(user);
//
//        User_7.USER.anyMethod();
    }
}
