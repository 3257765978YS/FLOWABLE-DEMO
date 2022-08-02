package JUC.c1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/9 16:22
 */
@Slf4j
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("sleeping...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        Thread.sleep(1000);
        log.debug("interrupt");
        t1.interrupt();
        log.debug("打断标记：{}",t1.isInterrupted());
    }
}
