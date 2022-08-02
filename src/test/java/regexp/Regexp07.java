package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/11/1 10:35
 */
public class Regexp07 {
    public static void main(String[] args) {
        String content = "https://www.bilibili.com/video/BV1fh411y7R8?p=894&spm_id_from=pageDriver";
//        String content = "https://www.bilibili.com";
        String regStr = "^((http|https)://)([\\w-]+\\.)+[\\w-]+(\\/[\\w-?&#=/%.]*)?$";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println("满足格式");
            System.out.println(matcher.group(0));
        }

        //整体匹配
        System.out.println(Pattern.matches(regStr,content));
    }
}
