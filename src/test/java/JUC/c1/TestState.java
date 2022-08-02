package JUC.c1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/10 10:36
 */
@Slf4j
public class TestState {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") { //new
            @Override
            public void run() {
                log.debug("running...");
            }
        };

        Thread t2 = new Thread("t2") { //runnable
            @Override
            public void run() {
                while(true){

                }
            }
        };
        t2.start();

        Thread t3 = new Thread("t3") { //terminated
            @Override
            public void run() {
                log.debug("running...");
            }
        };
        t3.start();

        Thread t4 = new Thread("t4") { //timed_waiting
            @Override
            public void run() {
                synchronized (TestState.class){
                    try{
                        Thread.sleep(1000000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t4.start();

        Thread t5 = new Thread("t5") { //waiting
            @Override
            public void run() {
                try{
                    t2.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t5.start();

        Thread t6 = new Thread("t6") { //blocked
            @Override
            public void run() {
                synchronized (TestState.class){
                    try{
                        Thread.sleep(1000000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t6.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.debug("t1 state {}",t1.getState());
        log.debug("t2 state {}",t2.getState());
        log.debug("t3 state {}",t3.getState());
        log.debug("t4 state {}",t4.getState());
        log.debug("t5 state {}",t5.getState());
        log.debug("t6 state {}",t6.getState());
    }
}
