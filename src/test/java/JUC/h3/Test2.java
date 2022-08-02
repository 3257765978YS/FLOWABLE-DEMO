package JUC.h3;



/**
 * @author : 杨帅
 * @description:
 * @date： 2022/3/3 13:21
 */
public class Test2 {
    public static void main(String[] args) {
        A a = new A("小明");
        a.changeValue(a);
        System.out.println(a);
    }



}
class A{
    String name;

    public A(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void changeValue(A a){
        a.setName("芜湖起飞");
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                '}';
    }
}
