package JUC.h2;

/**
 * @author : 杨帅
 * @description: JMM  有序性
 * @date： 2022/2/18 16:31
 */
public class Test25 {
    private int num = 0;
    private boolean ready = false;
    public static void main(String[] args) {
        //指令重排序

    }

    //线程1执行该方法
    public void actor1(I_Result r){
        if(ready){
            r.r1 = num + num;
        }else{
            r.r1 = 1;
        }
    }

    //线程2执行该方法
    public void actor2(I_Result r){
        num = 2;
        ready = true;
    }
}

class I_Result{
    int r1;

    public I_Result(int r1) {
        this.r1 = r1;
    }
}
