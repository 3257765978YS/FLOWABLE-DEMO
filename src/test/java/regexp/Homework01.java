package regexp;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/11/1 14:26
 */
public class Homework01 {
    public static void main(String[] args) {
        /**
         * 验证电子邮件：
         *      1.只能有一个@
         *      2.@前面是用户名，可以是a-z A-Z 0-9 _-字符
         *      3.@后面是域名，并且域名只能是英文字母，比如sohu.com或者tsinghua.org.cn
         *      4.写出对应的正则表达式，验证输入的字符穿是否满足规则
         */

        String mail1 = "yangshuai12516@suhu.com";
        String mail2 = "asdziia.123";
        String mail3 = "a@@dziia.123";
        String mail4 = "//@.com";
        String mail5 = "yangshuai@EDU.cn";

        boolean matches = mail5.matches("[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+");
        System.out.println(matches);

    }
}
