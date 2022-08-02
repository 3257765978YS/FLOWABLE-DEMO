package JUC.c1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/9 17:22
 */
@Slf4j
public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination termination = new TwoPhaseTermination();
        termination.start();
//        Thread.sleep(3500);
        termination.start();
        termination.start();
    }
}
@Slf4j
class TwoPhaseTermination{
    /**监控线程*/
    private Thread monitor;

    private volatile boolean stop = false;

    private boolean starting = false;

    public void start() {
        synchronized (this){
            if(starting){  //单线程下可以，多线程还是会出问题，要做保护
                return;
            }
        }
        starting = true;
        monitor = new Thread(()->{
            while(true){
//                    Thread currentThread = Thread.currentThread();
//                    if(currentThread.isInterrupted()){
                if(stop){
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);//情况1
                    log.debug("执行监控记录...");//情况2
                } catch (InterruptedException e) {
                    /*e.printStackTrace();
                    //重新设置打断标记,因为InterruptedException会将打断标记置为false
                    currentThread.interrupt();*/
                }
            }
        },"monitor");
        monitor.start();

    }

    public void stop(){
        stop = true;
        monitor.interrupt(); 
    }
}
