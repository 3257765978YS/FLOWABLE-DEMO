package JUC.h1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 杨帅
 * @description: ReentrantLock 锁  可中断、可设置超时时间、支持多个条件变量、支持可重入
 * @date： 2022/2/17 17:21
 */
@Slf4j
public class Test13 {

    //可重入测试
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {

        lock.lock();
        try {
            log.debug("进入主方法...");
            m1();
        } finally {
            lock.unlock();
        }


    }

    private static void m1() {
        lock.lock();
        try {
            log.debug("进入m1方法...");
            m2();
        } finally {
            lock.unlock();
        }
    }

    private static void m2() {
        lock.lock();
        try {
            log.debug("进入m2方法...");
        } finally {
            lock.unlock();
        }
    }
}
