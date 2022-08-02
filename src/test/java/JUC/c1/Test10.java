package JUC.c1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description: sleep()方法不会释放锁
 * @date： 2022/2/15 10:08
 */
@Slf4j
public class Test10 {
    static final Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (lock){
                try {
                    log.debug("t1获得锁");
//                    Thread.sleep(20000);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        Thread.sleep(1000);
        synchronized (lock){
            log.debug("主线程获得锁");
        }
    }
}
