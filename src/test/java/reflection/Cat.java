package reflection;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/13 14:00
 */
public class Cat {
    public String name = "宝马";
    public int age;
    public String color;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
