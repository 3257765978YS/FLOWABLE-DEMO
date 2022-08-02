package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 杨帅
 * @description: 选择匹配符
 * @date： 2021/10/29 09:41
 */
public class Regexp02 {
    public static void main(String[] args) {
        String content = "zhangguojun 张 涨停";
        String regStr = "zhang|张|涨";

        Pattern pattern = Pattern.compile(regStr);
//        Pattern pattern = Pattern.compile(regStr,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
}
