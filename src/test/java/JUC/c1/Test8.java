package JUC.c1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description: Guarded Suspension 保护行暂停 :一个线程等待另一个线程的结果
 * @date： 2022/2/14 15:25
 */
@Slf4j
public class Test8 {
    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();
        /*new Thread(()->{
            log.debug("等待结果");
            if(guardedObject.get(2000) == null){
                log.debug("下载超时...");
            }else{
                List<String> list = (List<String>) guardedObject.get(2000);
                log.debug("下载内容大小：{}",list.size());
            }
        },"t1").start();

        new Thread(()->{
            log.debug("执行下载");
            try {
                List<String> download = Downloader.download();
                guardedObject.complete(download);
            } catch (IOException e) {
                e.printStackTrace();
            }

        },"t2").start();*/

        new Thread(() -> {
            log.debug("等待结果");
            Object o = guardedObject.get(2000);
            log.debug("结果是{}", o);
        }, "t1").start();

        new Thread(() -> {
            log.debug("begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            guardedObject.complete(new Object());
            guardedObject.complete(null);
        }, "t2").start();
    }
}

//增加超时效果
class GuardedObject {
    //结果
    private Object response;

    //获取结果
    //timeout
    //表示要等待多久
    public Object get(long timeout) {
        synchronized (this) {
            //开始时间
            long begin = System.currentTimeMillis();
            //经历时间
            long passedTime = 0;
            while (response == null) {
                long waitTime = timeout - passedTime;
                //经历的时间超过最大时间，退出循环(下一轮等待时间小于等于0，退出循环)
                if (waitTime<=0) {
                    break;
                }
                try {
                    this.wait(waitTime); //虚假唤醒:complete()方法参数传入Null
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passedTime = System.currentTimeMillis() - begin;
            }
        }
        return response;
    }

    public void complete(Object response) {
        synchronized (this) {
            this.response = response;
            this.notifyAll();
        }
    }
}
