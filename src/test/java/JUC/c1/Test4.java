package JUC.c1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/9 16:45
 */
@Slf4j
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while(true){
                boolean interrupted = Thread.currentThread().isInterrupted();
                if(interrupted){
                    log.debug("被打断了，退出循环");
                    break;
                }
            }
        },"t1");
        t1.start();
        log.debug("interrupt");
        t1.interrupt();
        Thread.sleep(1000);
    }
}
