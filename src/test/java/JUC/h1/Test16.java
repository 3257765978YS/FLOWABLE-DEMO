package JUC.h1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 杨帅
 * @description: 创建一个新的条件变量
 * @date： 2022/2/18 09:51
 */

/**
 * 使用流程：
 * 1）await前需要获得锁
 * 2）await执行后，会释放锁，进入conditionObject等待
 * 3）await的线程被唤醒（或打断、或超时）取重新竞争lock锁
 * 4）竞争lock锁开始后，从await后继续执行
 */
@Slf4j
public class Test16 {
    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;
    static ReentrantLock ROOM = new ReentrantLock();
    //等待烟的休息室
    static Condition waitTackoutSet = ROOM.newCondition();
    //等待外卖的休息室
    static Condition waitCigaretteSet = ROOM.newCondition();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            ROOM.lock();
            try{
                log.debug("有烟没?[{}]", hasCigarette);
                while (!hasCigarette) {
                    log.debug("没烟，先歇会！");
                    try {
                        waitCigaretteSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("可以开始干活了");

            }finally {
                ROOM.unlock();
            }



        }, "小南").start();

        new Thread(() -> {
            ROOM.lock();
            try{
                log.debug("外卖到了吗?[{}]", hasTakeout);
                if (!hasTakeout) {
                    log.debug("没到，先歇会！");
                    try {
                        waitTackoutSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("可以开始干活了");
            }finally {
                ROOM.unlock();
            }
        }, "小女").start();

        Thread.sleep(1000);
        new Thread(() -> {
            ROOM.lock();
            try{
                hasTakeout = true;
                waitTackoutSet.signal();
            }finally {
                ROOM.unlock();
            }

        }, "送外卖的").start();

        Thread.sleep(1000);
        new Thread(() -> {
            ROOM.lock();
            try{
                hasCigarette = true;
                waitCigaretteSet.signal();
            }finally {
                ROOM.unlock();
            }

        }, "送烟的").start();
    }
}
