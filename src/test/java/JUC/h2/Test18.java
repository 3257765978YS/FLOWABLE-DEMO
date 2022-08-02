package JUC.h2;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @author : 杨帅
 * @description: 同步模式值顺序控制 park unpark
 * @date： 2022/2/18 10:25
 */
@Slf4j
public class Test18 {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            LockSupport.park();
            log.debug("1");
        }, "t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            log.debug("2");
            LockSupport.unpark(t1);

        }, "t2");
        t2.start();
    }
}
