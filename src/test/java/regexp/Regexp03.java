package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 杨帅
 * @description: 限定符（用于指定其前面的字符和组合连续出现的次数）
 * @date： 2021/10/29 09:44
 */
public class Regexp03 {

    /**
     *  1、 * ：0次或n次  (abc)*
     *  2、 + ：至少1次   m+(abc)*
     *  3、 ? ：最多1次   m+abc? (以至少一个m开头，后接ab或abc的字符串，注：?只作用在c上)
     *  4、 {n} ：n次     [abcd]{3}
     *  5、 {n,} ：至少n次     [abcd]{3,}
     *  5、 {n,m} ：n-m次     [abcd]{3,5}
     */


    public static void main(String[] args) {

        String content = "a1111111aaaahello";
//        String regStr = "a{3}";
//        String regStr = "1{4}";
//        String regStr = "\\d{2}";


//        String regStr = "a{3,5}";
        //细节：Java匹配默认贪婪匹配，即尽可能匹配多的字符串
//        String regStr = "1{4,5}";
//        String regStr = "\\d{2,5}";


//        String regStr = "1+";
//        String regStr = "\\d+";

//        String regStr = "1*";
//        String regStr = "\\d*";


        String regStr = "a1?";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
}
