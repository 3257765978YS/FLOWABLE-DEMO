package demo;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/1 10:17
 */
public class TimesExpression {
    public static void main(String[] args) {
        Person p1 = new Person("张三", -1, "学徒");
        Person p2 = new Person("李四", 10, "服务员");
        Person p3 = new Person("王五", 9, "经理");
        Person p4 = new Person("赵六", 38, "经理");
        Person p5 = new Person("齐七", 24, "经理");
        Person[] pList= {p1,p2,p3,p4,p5};
        for (Person person : pList) {
            System.out.println(person);
        }
        System.out.println();
        Person person=new Person();
        Person[] npList = person.BubbleSort(pList);
        for (Person p : npList) {
            System.out.println(p);
        }
    }
}

class Person {
    private String name;
    private Integer age;
    private String job;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "demo.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }

    public Person(){

    }
    public Person(String name, Integer age, String job) {
        this.name=name;
        this.age = age;
        this.job = job;
    }

    public Person[] BubbleSort(Person[] people){
        Person temp=new Person();
        int size=people.length;
        int[] age=new int[size];

        for (int i = 0; i < size; i++) {
            age[i]=people[i].getAge();
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size-1-i; j++) {
                if(age[j]>age[j+1]){
                    temp=people[j];
                    people[j]=people[j+1];
                    people[j+1]=temp;
                }
            }
        }
        return people;
    }
}







