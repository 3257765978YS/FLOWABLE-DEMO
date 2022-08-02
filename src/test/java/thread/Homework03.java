package thread;

import java.util.Random;
import java.util.Scanner;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/30 14:24
 */
public class Homework03 {
    public static void main(String[] args) {
        T t = new T();
        R r = new R(t);
        t.start();
        r.start();
    }
}
class  T extends Thread{
    Random random = new Random();
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while(loop){
            System.out.println(random.nextInt(100)+1);
//            System.out.println((int)(Math.random() * 101));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("T线程已结束");

    }
}

class R extends Thread{
    private T t;
    private Scanner myScanner = new Scanner(System.in);

    public R(T t) {
        this.t = t;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("请输入一个字符");
            char c = myScanner.next().toUpperCase().charAt(0);
            if(c =='Q'){
                t.setLoop(false);
                break;
            }
        }
        System.out.println("R线程已结束");

    }


}
