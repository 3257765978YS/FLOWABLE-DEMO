package JUC.h2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description:  可见性
 * @date： 2022/2/18 14:54
 */
@Slf4j
public class Test22 {
    final static Object lock = new Object();

    /*
     * volatile（易变关键字）它可以用来修饰成员变量和静态成员变量，
     * 它可以避免线程从自己的工作缓存中查找变量的值，必须到主存中获取它的值，线程操作volatile变量都是直接操作主存 （保证可见性）
     * volatile和synchronized都可以保证共享变量的可见性，推荐使用volatile
     */

//    volatile static boolean run = true;
    static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while(true){
//                log.debug("运行中...");
                System.out.println();  //源码内有synchronized，故保证了可见性
//                synchronized (lock){
                    if(!run){
                        break;
//                    }
                }

            }
        },"t1").start();

        Thread.sleep(1000);
        log.debug("停止 t");
//        synchronized (lock){
            run = false;//main线程对run变量的修改对t线程不可见，导致了t线程无法结束
//        }

    }
}
