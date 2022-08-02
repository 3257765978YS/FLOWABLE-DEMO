package JUC.h2;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 杨帅
 * @description:  使用 await  signal 进行交替打印
 * @date： 2022/2/18 10:46
 */
@Slf4j
public class Test20 {
    public static void main(String[] args) throws InterruptedException {
        AwaitSignal as = new AwaitSignal(5);
        Condition a = as.newCondition();
        Condition b = as.newCondition();
        Condition c = as.newCondition();
        new Thread(()->{
            as.print("a",a,b);
        }).start();
        new Thread(()->{
            as.print("b",b,c);
        }).start();
        new Thread(()->{
            as.print("c",c,a);
        }).start();

        Thread.sleep(1000);
        as.lock();
        try{
            log.debug("开始...");
            a.signal();
        }finally {
            as.unlock();
        }
    }
}
class AwaitSignal extends ReentrantLock{
    private int loopNumber;

    public AwaitSignal(int loopNumber){
        this.loopNumber = loopNumber;
    }

    //参数1 打印内容， 参数2 进入哪一间休息室  参数3 下一间休息室
    public void print(String str,Condition current,Condition next){
        for (int i = 0; i < loopNumber; i++) {
            lock();
            try{
                current.await();
                System.out.print(str);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unlock();
            }
        }
    }
}

