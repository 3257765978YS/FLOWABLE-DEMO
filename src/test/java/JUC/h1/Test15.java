package JUC.h1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 杨帅
 * @description: ReentrantLock锁 可设置超时时间 tryLock(long timeout,TimeUnit.SECONDS),不带参数是立即结束等待
 * @date： 2022/2/18 09:25
 */
@Slf4j
public class Test15 {
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            log.debug("尝试获得锁");
            try {
                if (!lock.tryLock(2, TimeUnit.SECONDS)) {
                    log.debug("获取不到锁");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.debug("获得不到锁");
            }

            try {
                log.debug("获得到锁");
            } finally {
                lock.unlock();
            }
        },"t1");

        lock.lock();
        log.debug("获得到锁");
        t1.start();

        Thread.sleep(1000);
        log.debug("释放了锁");
        lock.unlock();
    }
}
