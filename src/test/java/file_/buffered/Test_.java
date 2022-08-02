package file_.buffered;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/8 10:43
 */
public class Test_ {
    public static void main(String[] args) {
        BufferedReader_ bufferedReader1 = new BufferedReader_(new FileReader_());
        bufferedReader1.read(10);
        BufferedReader_ bufferedReader2 = new BufferedReader_(new StringReader_());
        bufferedReader2.read(5);
        System.out.println("==============分割线===============");
        bufferedReader1.read();
        bufferedReader2.read();
    }
}
