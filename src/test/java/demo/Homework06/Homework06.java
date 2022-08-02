package demo.Homework06;

import java.util.*;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/22 13:19
 */
public class Homework06 {

    public static void main(String[] args) {
//        Person person = new Person("唐僧", VehicleFactory.getHorse());
//        person.common();
//        person.passRiver();
//        person.common();
//        person.passRiver();
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("张三", "2500", new MyDate(1998, 3, 20)));
        list.add(new Employee("张三", "12000", new MyDate(1998, 3, 12)));
        list.add(new Employee("张三", "100000", new MyDate(1999, 3, 12)));
        list.add(new Employee("张三", "100000", new MyDate(1995, 3, 12)));
        list.add(new Employee("张三", "100000", new MyDate(2002, 7, 6)));
        list.add(new Employee("张三", "100000", new MyDate(1984, 6, 6)));
        System.out.println("排序前的集合：" + list);
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
//                int o1Year = o1.getBirthday().getYear();
//                int o2Year = o2.getBirthday().getYear();
//                int o1Month = o1.getBirthday().getMonth();
//                int o2Month = o2.getBirthday().getMonth();
//                int o1Day = o2.getBirthday().getDay();
//                int o2Day = o2.getBirthday().getDay();
//                if (!(o1.getName().equals(o2.getName()))) {
//                    return o1.getName().compareTo(o2.getName());
//                } else if (o1Year > o2Year || (o1Year == o2Year && o1Month < o2Month) || (o1Year == o2Year && o1Month == o2Month && o1Day < o2Day)) {
//                    return 1;
//                } else {
//                    return -1;
//                }
                if(!(o1.getName().equals(o2.getName()))){
                    return o1.getName().compareTo(o2.getName());
                }else{
                    return o1.getBirthday().compareTo(o2.getBirthday());
                }

            }
        });

        System.out.println("排序后的集合：" + list);
    }


}

class Employee {
    private String name;
    private String sal;
    private MyDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String name, String sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal='" + sal + '\'' +
                ", birthday=" + birthday +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return name.equals(employee.name) && birthday.equals(employee.birthday);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, birthday);
//    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MyDate myDate = (MyDate) o;
//        return year == myDate.year && month == myDate.month && day == myDate.day;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(year, month, day);
//    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public int compareTo(MyDate o) {
        int yearMinus = year-o.getYear();
        int monthMinus = month-o.getMonth();
        int dayMinus = day-o.getDay();
        if(yearMinus !=0){
            return yearMinus;
        }else if(monthMinus!=0){
            return monthMinus;
        }else {
            return dayMinus;
        }
    }
}
