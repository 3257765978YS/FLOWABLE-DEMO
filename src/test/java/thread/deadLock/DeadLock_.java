package thread.deadLock;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/30 14:12
 */
public class DeadLock_ {
    public static void main(String[] args) {
        DeadLockDemo demo1 = new DeadLockDemo(true);
        DeadLockDemo demo2 = new DeadLockDemo(false);
        demo1.setName("线程1");
        demo2.setName("线程2");
        demo1.start();
        demo2.start();
    }
}

class DeadLockDemo extends Thread {
    private static Object o1 = new Object();
    private static Object o2 = new Object();
    private boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "进入 1");

                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "进入 2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入 3");

                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "进入 4");
                }
            }
        }
    }
}
