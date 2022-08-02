package JUC.c1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/15 09:47
 */
@Slf4j
public class Test9 {
    static final Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (obj) {
                log.debug("执行....");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其他代码");
            }
        }, "t1").start();

        new Thread(()->{
            synchronized (obj){
                log.debug("执行....");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其他代码");
            }
        },"t2").start();


        Thread.sleep(2000);
        log.debug("唤醒obj上其他线程");
        synchronized (obj){
//            obj.notify();//唤醒一个线程
            obj.notifyAll();  //唤醒所有
        }
    }
}
