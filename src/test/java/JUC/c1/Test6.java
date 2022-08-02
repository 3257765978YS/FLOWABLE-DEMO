package JUC.c1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

/**
 * @author : 杨帅
 * @description:  interrupt影响park线程
 * @date： 2022/2/10 09:44
 */
@Slf4j
public class Test6 {
    public static void main(String[] args) throws InterruptedException {
        test();
    }

    private static void test() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark...");
            log.debug("打断状态：{}", Thread.currentThread().isInterrupted()); //Thread.interrupted()

            LockSupport.park();//会失效,调用Thread.interrupted() 将打断标记置为false
            log.debug("unpark...");
        }, "t1");
        t1.start();

        sleep(1000);

        t1.interrupt();//用来打断 park()方法

    }
}
