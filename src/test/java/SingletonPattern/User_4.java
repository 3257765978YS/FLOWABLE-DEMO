package SingletonPattern;

/**
 * @author : 杨帅
 * @description: 懒汉式（双重校验锁）⭐
 * @date： 2021/9/13 14:41
 */


public class User_4 {
    private static volatile User_4 user;

    private User_4() {
    }

    public static User_4 getUser() {
        if (user == null) {
            //同步块
            synchronized (user) {
                ////第二重校验，检查实例是否存在，如果不存在才真正创建实例
                if (user == null) {
                    user = new User_4();
                }
            }
        }
        return user;
    }
}
/**
 * 首先我们看第一个问题，为什么要双重校验？
 * 大家想一下，如果不双重校验。
 *
 * 如果两个线程一起调用getUser方法，并且都通过了第一次的判断user==null，那么第一个线程获取了锁，
 * 然后实例化了user，然后释放了锁，然后第二个线程得到了线程，然后马上也实例化了user。这就不符合我们的单例要求了。
 *
 * 接着我们来看第二个问题，为什么要用volatile 修饰 user？
 *
 * 我们可能知道答案是防止指令重排。
 *
 * 那这个重排指的是哪？指的是user = new User_4()，我们感觉是一步操作的实例化对象，实际上对于JVM指令，是分为三步的：
 *
 * 分配内存空间  (1)  √
 * 初始化对象    (2)  √
 * 将对象指向刚分配的内存空间 (3)  √
 *
 * 有些编译器为为了性能优化，可能会把第二步和第三步进行重排序，顺序就成了：
 *
 * 分配内存空间  (1)   √
 * 将对象指向刚分配的内存空间 (3) X
 * 初始化对象  (2) X
 */

/**
 * 使用了volatile关键字后，可以保证有序性，指令重排序被禁止；
 * volatile还可以保证可见性，Java内存模型会确保所有线程看到的变量值是一致的。
 */
