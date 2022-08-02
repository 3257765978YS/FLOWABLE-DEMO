package demo.Homework06;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/22 13:18
 */
public class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            vehicles = VehicleFactory.getBoat();
        }
        System.out.println(vehicles);
        vehicles.work();
    }

    public void common() {
        if (!(vehicles instanceof Horse)) {
            vehicles = VehicleFactory.getHorse();
        }
        System.out.println(vehicles);
        vehicles.work();
    }

    public void airplane() {
        if (!(vehicles instanceof AirPlane)) {
            vehicles = VehicleFactory.getAirPlane();
        }
        vehicles.work();
    }

}
