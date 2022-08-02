package JUC.h2;

/**
 * @author : 杨帅
 * @description:  原子性vs可见性
 * 比较之前的i++、i--的例子，只能保证看到最新值，不能解决指令交错
 *
 * volatile只能保证可见性，不能保证原子性
 * synchronized即可保证原子性，也可保证可见性，但属于重量级操作，性能相对较低
 * @date： 2022/2/18 15:37
 */
public class Test23 {
    public static void main(String[] args) {

    }
}
