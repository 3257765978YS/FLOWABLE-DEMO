package thread.method;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/30 10:43
 */
@Slf4j
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        R r = new R();
        Thread t1 = new Thread(r,"t1");
        Thread t2 = new Thread(t,"t2");
        long start = 0;
        long end = 0;
        for (int i = 1; i <= 10; i++) {
            if(i==6){
                start = System.currentTimeMillis();
                t1.start();
                t2.start();
                t1.join();
                log.debug("t1 join end");
                t2.join();
                log.debug("t2 join end");
                end = System.currentTimeMillis();
            }
            System.out.println("hi" + i);
            Thread.sleep(1000);
        }
        System.out.println("主线程结束");
        log.debug("cost:{}",end-start);


    }
}
class R implements Runnable{
    @Override
    public void run() {
        int count = 0;
        while(true){
            System.out.println("hello..." + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count==6){
                break;
            }
        }
        System.out.println("子线程结束");

    }
}
class T implements Runnable{
    @Override
    public void run() {
        int count = 0;
        while(true){
            System.out.println("hello..." + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count==10){
                break;
            }
        }
        System.out.println("子线程结束");

    }
}

