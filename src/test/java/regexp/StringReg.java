package regexp;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/11/1 14:10
 */
public class StringReg {
    public static void main(String[] args) {
        String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了Apple公司Mac OS X的工业标准的支持。" +
                "2001年9月24日，J2EE1.3发布。2002年2月26日，J2SE1.4发布。";

        //使用正则表达式将JDK1.3、JDK1.4改为JDK
        content = content.replaceAll("JDK1\\.3|JDK1\\.4", "JDK");
        System.out.println(content);
        
        //验证一个手机号  要求：必须是138、139开头
//        content = "13600013355";
        content = "13800013355";
        boolean matches = content.matches("(138|139)\\d{8}");
        System.out.println(matches);

        //使用正则表达式进行分割,要求：按照#、-、数字、~来分割
        content = "hello#abc-jack12smith~北京";
        String[] split = content.split("#|-|\\d+|~");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
