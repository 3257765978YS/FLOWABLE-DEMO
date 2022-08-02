package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/11/1 13:25
 */
public class Regexp08 {
    public static void main(String[] args) {
        String content = "我我...要要要....学学..编编编程...Java...";
        String regStr = "\\.";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        content = matcher.replaceAll("");
        System.out.println("content = "+content);
//
//        regStr = "(.)\\1+";
//        pattern = Pattern.compile(regStr);
//        matcher = pattern.matcher(content);
//        while(matcher.find()){
//            System.out.println(matcher.group(0));
//        }
//        //使用反向引用$1来替换匹配到的内容
//        content = matcher.replaceAll("$1");
//        System.out.println(content);


        //使用一条语句来去重
        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
        System.out.println(content);
    }
}
