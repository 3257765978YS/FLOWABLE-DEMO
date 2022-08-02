package JUC.h1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/15 10:16
 */
@Slf4j
public class TestCorrectPostureStep1 {
    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (room) {
                log.debug("有烟没?[{}]", hasCigarette);
                if (!hasCigarette) {
                    log.debug("没烟，先歇会！");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("有烟没?[{}]", hasCigarette);
                if (hasCigarette) {
                    log.debug("可以开始干活了");
                }
            }
        },"小南").start();


        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                synchronized (room){
                    log.debug("可以开始干活了...");
                }
            },"其他人").start();
        }

        Thread.sleep(1000);

        new Thread(()->{
            //这里能不能加synchronized(room)？
//            synchronized (room){
                hasCigarette = true;
                log.debug("烟到了哟！");
//            }
        },"送烟的").start();
    }
}
