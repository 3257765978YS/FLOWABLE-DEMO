package JUC.c1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/22 17:16
 */
@Slf4j
public class Test101 {
    static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter++;  //临界区
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter--; //临界区
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t1.join();

        log.debug("{}",counter);
    }
}
