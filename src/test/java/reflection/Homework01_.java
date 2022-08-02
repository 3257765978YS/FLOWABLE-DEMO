package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/15 15:27
 */
public class Homework01_ {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Class<?> clazz = Class.forName("reflection.PrivateTest");
        Class<PrivateTest> clazz = PrivateTest.class;
        PrivateTest o = clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        Method getName = clazz.getMethod("getName");
        name.setAccessible(true);
        name.set(o,"what up tiger");
        System.out.println(getName.invoke(o));
    }
}
class PrivateTest{
    private String name = "hello kitty";

    public String getName() {
        return name;
    }
}
