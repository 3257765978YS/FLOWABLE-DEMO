package JUC.h1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description:  配合notifyAll()
 * while(条件不成立){
 *      lock.wait()
 * }
 * @date： 2022/2/15 10:36
 */
@Slf4j
public class TestCorrectPostureStep3 {
    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (room) {
                log.debug("有烟没?[{}]", hasCigarette);
                while (!hasCigarette) {
                    log.debug("没烟，先歇会！");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("有烟没?[{}]", hasCigarette);
                if (hasCigarette) {
                    log.debug("可以开始干活了");
                }else{
                    log.debug("没干成活..");
                }
            }
        }, "小南").start();

        new Thread(() -> {
            synchronized (room) {
                log.debug("外卖到了吗?[{}]", hasTakeout);
                if (!hasTakeout) {
                    log.debug("没到，先歇会！");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("外卖到了吗?[{}]", hasTakeout);
                if (hasTakeout) {
                    log.debug("可以开始干活了");
                }else{
                    log.debug("没干成活..");
                }
            }
        }, "小女").start();

        Thread.sleep(1000);


        new Thread(() -> {
            //这里能不能加synchronized(room)？
            synchronized (room) {
                hasTakeout = true;
                log.debug("外卖到了哟！");
//                room.notify();
                room.notifyAll();
            }
        }, "送外卖的").start();
    }
}
