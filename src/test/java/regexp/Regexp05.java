package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/11/1 09:46
 */
public class Regexp05 {
    public static void main(String[] args) {

        String content = "123-abccd7768 5889";
//        String regStr = "(\\d\\d)(\\d\\d)";

        
        //命名分组：即可以给分组取名
        String regStr = "(?<g1>\\d\\d)(?<g2>\\d\\d)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println("找到："+matcher.group(0));
//            System.out.println("找到第一组："+matcher.group(1));
//            System.out.println("找到第二组："+matcher.group(2));
            System.out.println("找到第一组："+matcher.group("g1"));
            System.out.println("找到第二组："+matcher.group("g2"));
        }

    }
}
