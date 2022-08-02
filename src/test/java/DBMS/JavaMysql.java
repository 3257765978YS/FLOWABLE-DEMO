package DBMS;

import java.sql.*;
import java.util.Scanner;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/15 16:20
 */
public class JavaMysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        //  一、利用反射动态加载驱动
//        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver = (Driver)aClass.newInstance();
//        //  二、静态加载，不利于项目的配置
////        Driver driver = new Driver();
//        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&&useSSL=false";
//        Properties properties = new Properties();
//        properties.setProperty("user","root");
//        properties.setProperty("password","123456");
//
//        Connection connection = driver.connect(url, properties);
//        System.out.println("连接成功"+connection);

        //  三、 借助DriverManager建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false","root","123456");
        String name;
        int id = 0;
        double price = 0;
        String introduce;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要插入的手机id：");
        id = scanner.nextInt();
        System.out.print("请输入要查询的手机名称：");
        name = scanner.next();
        System.out.print("请输入要插入的手机价格：");
        price = scanner.nextDouble();
        System.out.print("请输入要查询的手机介绍：");
        introduce = scanner.next();

//        String sql = "create table ys_goods( id int, name varchar(32), price double, introduce text)";
//        String sql = "insert into ys_goods values( 4,'摩托罗拉手机',12599,'这是一款高大上的手机')";
//        String sql = "select * from ys_goods where name = ?";
        String sql = "insert into ys_goods values(?,?,?,?)";
//
//        Statement statement = connection.createStatement();
//        statement.executeUpdate(sql);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setDouble(3,price);
        preparedStatement.setString(4,introduce);
//        ResultSet resultSet = preparedStatement.executeQuery();
        int rows = preparedStatement.executeUpdate();
//        ResultSet resultSet = statement.executeQuery(sql);
//        while(resultSet.next()){
//            int id1 = resultSet.getInt(1);
//            String name1 = resultSet.getString(2);
//            double price1 = resultSet.getDouble(3);
//            String introduce1 = resultSet.getString(4);
//            System.out.println(id + "\t" +name1 + "\t" + price + "\t" + introduce);
//        }
//        resultSet.close();

        if(rows > 0){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败~");
        }

        preparedStatement.close();
        connection.close();

//        System.out.println("创建表成功~");
//        System.out.println("新增一条数据成功~");

    }
}

class Logarithm {
    public static double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }
}

