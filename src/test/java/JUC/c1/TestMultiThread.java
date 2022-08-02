package JUC.c1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/8 13:35
 */
@Slf4j
public class TestMultiThread {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                log.debug("running...");
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                log.debug("running...");
            }
        }, "t2").start();
    }

}
