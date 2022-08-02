package demo.Homework06;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/22 13:16
 */
public class VehicleFactory {
    //懒汉式（双重校验锁）单例模式
    private static volatile Horse horse;

    private VehicleFactory(){};

    public static Horse getHorse(){
        if(horse ==null){
            //同步块
            synchronized (Horse.class){
                //第二重校验，检查实例是否存在，如果不存在才真正创建实例
                if (horse == null) {
                    horse = new Horse();
                }
            }
        }
        return horse;
    }

    public static Boat getBoat(){
        return new Boat();
    }

    public static AirPlane getAirPlane(){
        return new AirPlane();
    }
}
