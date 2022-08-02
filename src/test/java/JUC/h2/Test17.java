package JUC.h2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description: 同步模式值顺序控制 -> 固定运行顺序
 * @date： 2022/2/18 10:10
 */
@Slf4j
public class Test17 {
    //wait notify版

    static final Object lock = new Object();
    //表示t2是否运行过
    static boolean t2runned = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (lock){
                while(!t2runned){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
            }


        },"t1");

        Thread t2 = new Thread(()->{
            synchronized (lock){
                log.debug("2");
                t2runned = true;
                lock.notify();
            }

        },"t2");

        t1.start();
        t2.start();
    }
}
