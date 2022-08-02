package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 杨帅
 * @description: 定位符的使用
 * @date： 2021/11/1 09:00
 */
public class Regexp04 {
    public static void main(String[] args) {

        /**
         * ^ : 指定起始字符
         * $ : 指定结束字符
         * \\b : 匹配目标字符串的边界
         * \B : 匹配目标字符串的非边界
         */

        // ^[0-9]+[a-z]* 以至少一个数字开头，后接任意个小写字母的字符串  123
        // ^[0-9]\\-[a-z]+$  以至少一个数字开头，后接连接符"-"，并以一个小写字母结尾的字符串 1-a
        // han\\b  han后有空格，或以han结尾的字符串
        // han\\B 和\b的含义相反

        String content = "123-abccd";
//        String content = "haneduhan 123 nnhan";
//        String content = "1-a";
//        String regStr = "^[0-9]+[a-z]*";S
        String regStr = "^[0-9]+\\-[a-z]+$";
//        String regStr = "han\\b";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
}
