package JUC.c1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/7 17:21
 */
@Slf4j
public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("running...");
                Thread.sleep(2000);
                return 100;
            }
        });

        Thread t = new Thread(task,"t1");
        t.start();

        log.debug("{}",task.get());
    }
}
