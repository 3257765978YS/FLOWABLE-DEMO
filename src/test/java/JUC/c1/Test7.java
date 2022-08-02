package JUC.c1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description: 守护线程：例如GC垃圾回收器就是一个守护线程
 * @date： 2022/2/10 10:04
 */
@Slf4j
public class Test7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
            log.debug("结束");
        }, "t1");
        t1.setDaemon(true);
        t1.start();

        Thread.sleep(1000);
        log.debug("结束");
    }
}
