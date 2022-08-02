package demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/8/19 15:58
 */
public class CCTest {
    public static void main(String[] args) {
//        A a = new A();
//        a.f1();
//        String s = "123";
//        String s1 = new String("123");
//        System.out.println(s);
//        System.out.println(s1==s1.intern());
//        System.out.println(s==s1);
        String str = "2021-11-15 09:38:20";
        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
        DateTimeFormatter pattern2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str,pattern2);
        int hour = dateTime.getHour();
        int year = dateTime.getYear();
        int monthValue = dateTime.getMonthValue();
        int dayOfMonth = dateTime.getDayOfMonth();
        System.out.println("当前时间是"+year+"年"+monthValue+"月"+dayOfMonth+"日"+hour+"时");
        String format = dateTime.format(pattern);
        String format2 = now.format(pattern);
        System.out.println(format);
        System.out.println(format2);
    }

}
class A{
    private String NAME = "Hello";

    public void f1(){
        class B{
            private final String NAME = "海贼王";
            public void show(){
                System.out.println("NAME="+NAME+"\t外部类的私有属性="+A.this.NAME);
            }
        }

        B b = new B();
        b.show();
    }



}


