package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/11/1 09:54
 */
public class Regexp06 {
    public static void main(String[] args) {
        String content = "张三学习study 张三喝水drink 张三睡觉sleep";

//        String regStr = "张三学习|张三喝水|张三睡觉";
//        String regStr = "张三(?:学习|喝水|睡觉)"
//        String regStr = "张三(?=学习|喝水|睡觉)";
        String regStr = "张三(?!学习|喝水)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
}
