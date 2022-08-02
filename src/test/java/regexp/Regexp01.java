package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 杨帅
 * @description: 演示字符匹配符的使用
 * @date： 2021/10/29 09:18
 */
public class Regexp01 {
    public static void main(String[] args) {
        String content = "a11c8_abcABC @";

//        String regStr = "[a-z]";
//        String regStr = "[A-Z]";
        String regStr = "(?i)abc";
//        String regStr = "abc";
//        String regStr = "[0-9]";
//        String regStr = "[^a-z]";
//        String regStr = "[^a-z]{2}";
//        String regStr = "\\d"; //相当于[0-9]
//        String regStr = "\\D"; //相当于[^0-9]
//        String regStr = "\\w"; //匹配字母、数字、下划线
//        String regStr = "\\W"; //匹配非字母、数字、下划线
//        String regStr = "\\s"; //匹配任何空白字符
//        String regStr = "\\S"; //匹配任何非空白字符
//        String regStr = "."; //匹配所有字符
//        String regStr = "a.c"; //匹配以a开头,c结尾的字符，中间有一个任意字符

        Pattern pattern = Pattern.compile(regStr);
//        Pattern pattern = Pattern.compile(regStr,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
    
}
