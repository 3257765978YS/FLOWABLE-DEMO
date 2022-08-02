package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/11/1 11:18
 */
public class MatcherMethod {
    public static void main(String[] args) {
//        String content = "hello edu 1551hspedutom jack hsp1234edu hspedu";
        String content = "hello edu 1551hspedu12321-333999111tom jack hsp1234edu hspedu";
//        String regStr = "hspedu";
//        String regStr = "(\\d)(\\d)\\2\\1";
        String regStr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";

        Pattern pattern = Pattern.compile(regStr);
//        Pattern pattern = Pattern.compile(regStr,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

//        String s = matcher.replaceAll("张三的手");
//        System.out.println(s);

        while(matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }

        //反向应用

    }
}
