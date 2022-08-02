package SingletonPattern;

/**
 * @author : 杨帅
 * @description: 单例模式（枚举）
 * @date： 2021/9/13 14:58
 */
public enum User_7 {
    USER;
    public void anyMethod(){
        System.out.println("do any thing");
    }
}
/**
 * 调用方式：
 *
 *     @Test
 *     void anyMethod() {
 *         Singleton_7.INSTANCE.anyMethod();
 *     }
 */
