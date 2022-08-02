package reflection;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/15 15:39
 */
public class Homework02_ {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException, ClassNotFoundException {
//        Class<File> fileClass = File.class;
        Class<?> fileClass = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = fileClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        Method createNewFile = fileClass.getMethod("createNewFile");
        Constructor<?> constructor = fileClass.getDeclaredConstructor(String.class);
        Object file = constructor.newInstance("e:\\softwares\\mynew.txt");
        createNewFile.invoke(file);
    }
}

