package demo;

import java.util.Random;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/12/8 17:41
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(LocalDateTime.now().getMonthValue());
//        List<Student> list1 = new ArrayList<>();
//        Student s1 = new Student("张三", "20");
//        Student s2 = new Student("李四", "22");
//        Student s3 = new Student("王五", "24");
//        Student s4 = new Student("小毛", "21");
//        Student s5 = new Student("赵六", "18");
//        list1.add(s1);
//        list1.add(s2);
//        list1.add(s3);
//        list1.add(s4);
//        list1.add(s5);
//        Map<String, String> collect1 = list1.stream().collect(Collectors.toMap(Student::getName, Student::getAge));
//        System.out.println(collect1);
//        Map<String, List<Student>> collect2 = list1.stream().collect(Collectors.groupingBy(Student::getAge));
//        System.out.println(collect2);
//        list1.stream().sorted((o1, o2) -> {
//            if(!o1.getName().equals(o2.getName())){
//                return Integer.parseInt(o1.getAge())-Integer.parseInt(o2.getAge());
//            }else{
//                return o1.getName().compareTo(o2.getName());
//            }
//        }).forEach(System.out::println);
//
//        List<String> list = Arrays.asList("a,b,c", "1,2,3");
//        List<String> collect = list.stream().map(s -> s.replaceAll(",", "")).collect(Collectors.toList());
//        System.out.println(collect);
        System.out.println(Student.getRandomString(3));
    }
}
class Student{
    private String name;
    private String age;

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static String getRandomString(Integer num) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
