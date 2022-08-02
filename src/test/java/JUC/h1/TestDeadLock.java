package JUC.h1;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 杨帅
 * @description: 哲学家午餐问题（死锁） 解决方法：1）按顺序加锁，但会产生饥饿问题（某个对象一直运行）
 * @date： 2022/2/17 16:48
 */
@Slf4j
public class TestDeadLock {
    public static void main(String[] args) {
        Chopstick c1 = new Chopstick("1");
        Chopstick c2 = new Chopstick("2");
        Chopstick c3 = new Chopstick("3");
        Chopstick c4 = new Chopstick("4");
        Chopstick c5 = new Chopstick("5");
        new Philosopher("苏格拉底",c1,c2).start();
        new Philosopher("柏拉图",c2,c3).start();
        new Philosopher("亚里士多德",c3,c4).start();
        new Philosopher("赫拉克利特",c4,c5).start();
        new Philosopher("阿基米德",c5,c1).start();
    }
}
@Slf4j
class Philosopher extends Thread{

    Chopstick left;
    Chopstick right;

    public Philosopher(String name,Chopstick left,Chopstick right){
        super(name);
        this.left = left;
        this.right = right;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            //改用ReentrantLock 解决死锁问题，因为能及时释放锁
            /*synchronized (left){
                synchronized (right){
                    eat();
                }
            }*/
            //尝试获取左手筷子
            if (left.tryLock()) {
                //尝试获取右手筷子
                try {
                    if (right.tryLock()){
                        try{
                            eat();
                        }finally {
                            right.unlock();
                        }
                    }
                } finally {
                    left.unlock();
                }
            }
        }
    }

    private void eat() throws InterruptedException {
        log.debug("eating...");
        Thread.sleep(1000);
    }
}

class Chopstick extends ReentrantLock {
    String name;

    Chopstick(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "筷子{" +name +"}";
    }
}