package JUC.h2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : 杨帅
 * @description: 同步模式值交替输出  wait  notify  (添加一个等待标记)
 * @date： 2022/2/18 10:30
 */
@Slf4j
public class Test19 {
    public static void main(String[] args) {

        WaitNotify wn = new WaitNotify(1, 5);
        new Thread(()->{
            wn.print("a",1,2);
        }).start();
        new Thread(()->{
            wn.print("b",2,3);
        }).start();
        new Thread(()->{
            wn.print("c",3,1);
        }).start();
    }
}

/*
输出内容   等代标记   下一个标记
    a         1          2
    b         2          3
    c         3          1

 */
class WaitNotify{
    //打印
    public void print(String str,int waitFlag,int nextFlag){
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this){
                while(flag!=waitFlag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }
    //等待标记
    private int flag;//1
    private int loopNumber;

    public WaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }
}