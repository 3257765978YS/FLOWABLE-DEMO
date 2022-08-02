package reflection;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/13 14:00
 */
public class Class01_ {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InstantiationException {

        /**
         * 获取类的三种方式
         */
        //1、通过实例对象获取（在程序运行阶段）
        Cat cat = new Cat();
        String classAllPath = "reflection.Cat";
        Class<?> clazz1 = cat.getClass();
        //2、通过同一包下的 类.class获取（在类加载阶段）
        Class<?> clazz2 = Cat.class;
        //3、通过Class.forName 类的全路径名获取（在代码编译阶段）
        Class<?> clazz3 = Class.forName("reflection.Cat");
        //4、通过类加载器来获取到类的Class对象
        //1)先得到类加载器classLoader
        ClassLoader classLoader = cat.getClass().getClassLoader();
        //2)通过类加载器得到Class对象
        Class<?> clazz4 = classLoader.loadClass(classAllPath);


        //5、基本数据类型获取Class对象
//        Class<Integer> integerClass = int.class;
//        Class<Double> doubleClass = double.class;

        //6、基本类型对应的包装类，通过.Type得到Class对象
//        Class<Integer> integerClass = Integer.TYPE;
//        Class<Character> characterClass = Character.TYPE;

        //实例化类对象
//        Cat cat = (Cat) clazz.newInstance();
//        System.out.println(clazz.getName());
//        Field name = clazz.getField("name");
//        System.out.println(name.get(cat));
//        Field[] fields = clazz.getFields();
//        for (Field field : fields) {
//            System.out.println(field.getName());
//        }
    }


}
