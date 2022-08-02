package regexp;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/11/1 16:00
 */
public class Homework03 {
    public static void main(String[] args) {
        /**
         * 要求对一个url进行解析
         */

        //http://www.sohu.com:8080/abc/index.htm
        //a)要求得到的协议是什么？ http
        //b)域名是什么？ www.sohu.com
        //c)端口是什么？ 8080
        //d)文件名是什么？ index.htm

//        String content = "http://www.sohu.com:8080/abc/xxx/index.htm";
//
//
//        String regStr = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w-.]+)$";
//
//        Pattern pattern = Pattern.compile(regStr);
//        Matcher matcher = pattern.matcher(content);
//        if(matcher.matches()){
//            System.out.println("匹配成功");
//            System.out.println(matcher.group(0));
//            System.out.println("协议是："+matcher.group(1));
//            System.out.println("域名是："+matcher.group(2));
//            System.out.println("端口是："+matcher.group(3));
//            System.out.println("文件名是："+matcher.group(4));
//
//        }else{
//            System.out.println("匹配失败");
//        }
        String content = "http://59.215.190.105:8080/gz/hj/gzcg/gzcg-zyjxzx/FileServer/downLoadServer?fileGUID=f5b7b5a8-b3e8-4e6e-bed6-9cafbaae5660.apk&fileName=__UNI__9E3FC0C__20220407144729.apk";
        System.out.println(getGuidFromStr(content).length());
        System.out.println("f5b7b5a8-b3e8-4e6e-bed6-9cafbaae5660.apk".length());

    }

    public static String getGuidFromStr(String str){
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            int j = i + 1;
            if(chars[i] == 'D' && chars[j] == '='){
                index = j+1;
                break;
            }
        }
        for (int i = index; i < chars.length; i++) {
            if(chars[i] != '.'){
                sb.append(chars[i]);
            }else{
                sb.append(".apk");
                break;
            }
        }
        return sb.toString();
    }
}
