package JUC.h1;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/22 16:26
 */
@Slf4j
public class TestThreadSafe {
    static final int THREAD_NUMBER = 2;
    static final int LOOP_NUMBER = 2000;
    public static void main(String[] args) {
        ThreadSafeSubClass test = new ThreadSafeSubClass();
        for (int i = 0; i < THREAD_NUMBER; i++) {
            new Thread(()->{
                test.method1(LOOP_NUMBER);
            },"Thread"+(i+1)).start();
        }
    }
}
class ThreadSafe{

    public final void method1(int loopNumber){
        ArrayList<String> list =  new ArrayList<>();
        for (int i = 0; i < loopNumber; i++) {
            method2(list);
            method3(list);
        }
    }
    public void method2(ArrayList<String> list) {
        list.add("1");
    }

    public void method3(ArrayList<String> list) {
        list.remove(0);
    }
}

class ThreadSafeSubClass extends ThreadSafe{
    @Override
    public void method3(ArrayList<String> list){
        new Thread(()->{
            list.remove(0);
        }).start();
    }
}
