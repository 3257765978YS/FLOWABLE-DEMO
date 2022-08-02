package JUC.c1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/7 15:51
 */
@Slf4j
public class Test1 {
    public static void main(String[] args) {
        Runnable r = () -> log.debug("Running...");


        Runnable r1 = () -> log.debug("Debugging...");

        Thread t = new Thread(r,"t1");
        t.start();
    }
}
