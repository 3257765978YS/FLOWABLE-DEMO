package JUC.h1;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/22 13:35
 */
@Slf4j
public class Test2 {
    public static void main(String[] args) {
        Number n1 = new Number();
        Number n2 = new Number();
        new Thread(()->{
            log.debug("begin");
            try {
                n1.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            log.debug("begin");
            n2.b();
        }).start();

        /*new Thread(()->{
            log.debug("begin");
            n1.c();
        }).start();*/
    }
}

@Slf4j
class Number{
    public static synchronized void a() throws InterruptedException {
        sleep(1000);
        log.debug("1");
    }

    public static synchronized void b(){
        log.debug("2");
    }

    public void c(){
        log.debug("3");
    }
}

