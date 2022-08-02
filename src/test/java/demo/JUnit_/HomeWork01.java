package demo.JUnit_;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/29 10:11
 */
public class HomeWork01 {
    public static void main(String[] args) {
        System.out.println(2 <<3);

    }
    @Test
    public void test(){
        DAO<User> dao = new DAO<>();
        dao.addOrUpdate("001",new User(1,18,"张三"));
        dao.addOrUpdate("002",new User(2,28,"李四"));
        dao.addOrUpdate("003",new User(3,38,"王五"));
        System.out.println(dao.list());
        dao.addOrUpdate("001",new User(1,18,"张三三"));
        System.out.println(dao.list());
        System.out.println(dao.get("001"));
        dao.delete("001");
        System.out.println(dao.list());
    }


}
class User{
    public int id;
    public int age;
    public String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}

class DAO<T> {

    private Map<String, T> map = new HashMap<>();

    public void addOrUpdate(String id, T entity) {
        map.put(id,entity);
    }

    public void delete(String id){
        map.remove(id);
    }

    public List<T> list(){
        List<T> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(get(s));
        }
        return list;
    }

    public T get(String id){
        return map.get(id);
    }


}

