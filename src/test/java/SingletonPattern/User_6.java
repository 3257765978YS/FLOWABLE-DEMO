package SingletonPattern;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : 杨帅
 * @description: 单例模式（CAS）
 * @date： 2021/9/13 14:54
 */
public class User_6 {
    private static final AtomicReference<User_6> USER = new AtomicReference<User_6>();

    private User_6() {
    }

    public static final User_6 getInstance() {
        //等待
        while (true) {
            User_6 user = USER.get();
            if (null == user) {
                USER.compareAndSet(null, new User_6());
            }
            return USER.get();
        }
    }

}

/**
 * CAS式的单例模式算是懒汉式直接加锁的一个变种，sychronized是一种悲观锁，而CAS是乐观锁，相比较，更轻量级。
 *
 * 当然，这种写法也比较罕见，CAS存在忙等的问题，可能会造成CPU资源的浪费。
 */
