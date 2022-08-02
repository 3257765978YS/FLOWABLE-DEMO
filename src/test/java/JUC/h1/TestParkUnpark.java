package JUC.h1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @author : 杨帅
 * @description: park、unpark 以线程为单位唤醒，且必须配合Object Monitor一起使用
 * ，wait、notify则随机唤醒
 * park、unpark可以先unpark  而wait、notify不可以先notify
 * @date： 2022/2/15 16:24
 */
@Slf4j
public class TestParkUnpark {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("start...");
            try {
                Thread.sleep(1000);
//                Thread.sleep(2000);  //park前先unpark，则在park时会失效
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("park...");
            LockSupport.park();
            log.debug("resume...");
        }, "t1");
        t1.start();

        Thread.sleep(2000);
//        Thread.sleep(1000);
        log.debug("unpark...");
        LockSupport.unpark(t1);
    }
}
