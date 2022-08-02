package JUC.h1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 杨帅
 * @description:  ReentrantLock锁  可打断测试
 * @date： 2022/2/18 09:07
 */
@Slf4j
public class Test14 {
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                //如果没有竞争 那么此方法就会获取lock对象锁
                //如果有竞争 就进入阻塞队列 可以被其他线程用interrupt 方法打断
                log.debug("尝试获得锁");
                lock.lockInterruptibly();
//                lock.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.debug("没有获得锁，返回");
                return;
            }

            try {
                log.debug("获取到锁");
            } finally {
                lock.unlock();
            }
        },"t1");

        lock.lock();
        t1.start();

        Thread.sleep(1000);
        log.debug("打断t1");
        t1.interrupt();
    }
}
