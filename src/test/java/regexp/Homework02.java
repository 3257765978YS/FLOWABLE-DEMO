package regexp;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/11/1 15:12
 */
public class Homework02 {
    public static void main(String[] args) {
        /**
         * 要求验证是不是整数说着小数
         * (要考虑正负数)
        String data = "123";
        String data1 = "-345";
        String data2 = "34.89";
        String data3 = "-87.9";
        String data4 = "-0.01";
        String data5 = "0.45";

        String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        if(data4.matches(regStr)){
            System.out.println("匹配成功");
        }else{
            System.out.println("匹配失败");
        }*/

        String content = "           15  C  S          W04-FS-201109-1                                0            -0.570         -0.0163                     < HS  accept";
        String [] arr = content.split("\\s+");
        int len = arr.length;
        for (int i = 0; i <len ; i++) {
            System.out.println(arr[i]);
        }

    }
}
