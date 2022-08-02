package JUC.h2;

import java.util.Arrays;
import java.util.List;

/**
 * @author : 杨帅
 * @description: 同步模式之Balking  详细内容建 Test 5
 * @date： 2022/2/18 15:48
 */
public class Test24 {

    /*
    * Balking(犹豫)模式用在一个线程发现另一个线程或本线程已经做了某一件相同的事，
    * 那本本线程就无须再做了，直接结束返回
    *
    * */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3");
        System.out.println(String.join("->",list));
    }
}
