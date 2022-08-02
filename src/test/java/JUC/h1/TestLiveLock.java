package JUC.h1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description: 活锁：两个线程互相左右，导致都不能结束运行  ->解决方法：其中一个线程进行随机睡眠
 * @date： 2022/2/17 17:08
 */
@Slf4j
public class TestLiveLock {
    static volatile int count = 10;
    static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            while(count>0){
                //期望减到0 退出循环
                try {
                    Thread.sleep(200);
                    count--;
                    log.debug("count:{}",count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"t1").start();

        new Thread(()->{
            while(count<20){
                //期望超过20 退出循环
                try {
                    Thread.sleep(200);
                    count++;
                    log.debug("count:{}",count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"t2").start();
    }

}
