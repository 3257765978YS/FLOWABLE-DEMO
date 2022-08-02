package JUC.c1;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/8 14:19
 */
public class TestFrames {
    public static void main(String[] args) {
        new Thread(()->{
            method1(20);
        },"t1").start();
        method1(10);
    }
    private static void method1(int x){
        int y = x + 1;
        Object m = method2();
        System.out.println(m);
    }

    private static Object method2() {
        Object n = new Object();
        return n;
    }
}
