package thread;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/30 14:57
 */
public class Homework04 {
    public static void main(String[] args) {
        Card card = new Card();
        Thread bro1 = new Thread(card);
        Thread bro2 = new Thread(card);
        bro1.setName("张三");
        bro2.setName("李四");
        bro1.start();
        bro2.start();
    }
}

class Card implements Runnable {
    private static int total = 10000;


    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (total == 0) {
                    System.out.println("余额不足");
                    break;
                }
                total -= 1000;
                System.out.println(Thread.currentThread().getName() + "取走了1000，余额为："+total);

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


