package thread;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/30 09:23
 */
public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println("当前有"+i+"个CPU");
    }
}
