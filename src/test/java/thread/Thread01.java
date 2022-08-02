package thread;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/30 09:33
 */
public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();

        for (int i = 0; i < 60; i++) {
            System.out.println("主线程i="+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Cat extends Thread {
    int times;

    @Override
    public void run() {
        while (true) {
            System.out.println("汪汪，我是小黄~" + ++times);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
