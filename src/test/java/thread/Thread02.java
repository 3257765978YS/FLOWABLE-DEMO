package thread;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/30 10:02
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();
    }
}
class Dog implements Runnable{

    @Override
    public void run() {
        int count = 0;
        while(true){
            System.out.println("小狗汪汪叫" + (++count) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count==10){
                break;
            }
        }


    }
}
