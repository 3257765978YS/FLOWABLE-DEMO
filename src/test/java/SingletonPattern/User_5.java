package SingletonPattern;

/**
 * @author : 杨帅
 * @description: 单例模式（静态内部类）
 * @date： 2021/9/13 14:47
 */
public class User_5 {

    private User_5(){}

    private static class InnerUser {
        private static final User_5 user = new User_5();
    }

    public static User_5 getUser(){
        return InnerUser.user;
    }
}
/**
 * 静态内部类是更进一步的写法，不仅能实现懒加载、线程安全，而且JVM还保持了指令优化的能力。
 *
 * Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，
 * 才会加载静态内部类InnerSingleton类，从而完成Singleton的实例化。
 *
 * 类的静态属性只会在第一次加载类的时候初始化，同时类加载的过程又是线程互斥的，JVM帮助我们保证了线程安全。
 */
