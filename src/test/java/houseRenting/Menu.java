package houseRenting;

import houseRenting.pojo.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/10 14:39
 */
public class Menu {
    private int choseNumber;
    private List<House> houses = new ArrayList<>();
    private boolean loop = true;
    private Scanner myScanner;

    public Menu() {
    }

    public void show() {
        do {
            System.out.println("------------------------房屋出租系统-------------------------");
            System.out.println("\t\t\t\t\t1  新  增  房  源");
            System.out.println("\t\t\t\t\t2  查  看  房  源");
            System.out.println("\t\t\t\t\t3  删  除  房  源");
            System.out.println("\t\t\t\t\t4  修  改  房  屋  信  息");
            System.out.println("\t\t\t\t\t5  房  屋  列  表");
            System.out.println("\t\t\t\t\t6  退          出");
            System.out.println();
            myScanner = new Scanner(System.in);
            System.out.print("请选择您要进行的操作：");
            choseNumber = myScanner.nextInt();
            switch (choseNumber) {
                case 1:
                    addHouse();
                    break;
                case 2:
                    searchHouse();
                    break;
                case 3:
                    deleteHouse();
                    break;
                case 4:
                    updateHouse();
                    break;
                case 5:
                    houseList();
                    break;
                case 6:
                    close();
                    break;
                default:
                    System.out.println("选择有误，请重试！");
            }
        } while (loop);
        if (!loop) {
            System.out.println("你退出了程序~~");
        }
    }

    public void addHouse() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("------------------------添加房屋-------------------------");
        System.out.print("姓名：");
        String household = myScanner.next();
        System.out.print("电话：");
        String phone = myScanner.next();
        System.out.print("地址：");
        String address = myScanner.next();
        System.out.print("月租：");
        int monthlyPay = myScanner.nextInt();
        System.out.print("状态(未出租/已出租)：");
        String state = myScanner.next();
        System.out.println("------------------------添加完成-------------------------\n");
        House house = new House(household, phone, address, monthlyPay, state);
        houses.add(house);
    }

    public void searchHouse() {
        boolean flag = true;
        myScanner = new Scanner(System.in);
        do {
            System.out.println("------------------------查找房屋-------------------------");
            System.out.print("请输入你要查找的房屋id：");
            int id = myScanner.nextInt();
            if (houses.size() < id || id <= 0) {
                flag = false;
                System.out.println("------------------------没有该房屋-------------------------\n");
            } else {
                System.out.println("\n" + id + "\t" + houses.get(id-1).getHousehold() + "\t" + houses.get(id-1).getPhone() +
                        "\t" + houses.get(id-1).getAddress() + "\t" + houses.get(id-1).getMonthlyPay() + "\t" + houses.get(id-1).getState());
            }
        } while (flag);
    }

    public void deleteHouse() {
        boolean flag = true;
        myScanner = new Scanner(System.in);
        do {
            System.out.println("------------------------删除房屋-------------------------");
            System.out.print("请选择待删除房屋编号(-1退出)：");
            int id = myScanner.nextInt();
            if (id == -1) {
                return;
            }
            System.out.println("确认是否删除(Y/N)：请小心选择：");
            System.out.print("请输入你的选择(Y/N)：");
            String s = myScanner.next();
            if ("Y".equals(s)) {
                houses.remove(id - 1);
                flag = false;
                System.out.println("------------------------删除完成-------------------------\n");
            }else if ("N".equals(s)){
                return;
            }
        } while (flag);

    }

    public void updateHouse() {
        myScanner = new Scanner(System.in);
        System.out.println("------------------------修改房屋-------------------------");
        System.out.print("请选择待修改房屋编号(-1退出)：");
        int id = myScanner.nextInt();
        if (id == -1) {
            return;
        }
        System.out.print("\n姓名：");
        String household = myScanner.next();
        System.out.print("\n电话：");
        String phone = myScanner.next();
        System.out.println("\n地址：");
        String address = myScanner.next();
        System.out.println("\n月租：");
        int monthlyPay = myScanner.nextInt();
        System.out.println("\n状态(未出租/已出租)：");
        String state = myScanner.next();
        House house = houses.get(id - 1);
        house.setHousehold(household);
        house.setAddress(address);
        house.setPhone(phone);
        house.setMonthlyPay(monthlyPay);
        house.setState(state);
        System.out.println("------------------------修改房屋完成-------------------------\n");
    }

    public void houseList() {
        System.out.println("------------------------房屋列表-------------------------");
        System.out.println("编号\t房主\t电话\t地址\t月租\t状态(未出租/已出租)");
        int size = houses.size();
        for (int i = 0; i < size; i++) {
            System.out.print(i + "\t\t" + houses.get(i).getHousehold() + "\t\t" + houses.get(i).getPhone() + "\t\t" + houses.get(i).getAddress() +
                    "\t\t" + houses.get(i).getMonthlyPay() + "\t\t" + houses.get(i).getState());
            System.out.println();
        }
        System.out.println("------------------------房屋列表完成-------------------------\n");
    }

    public void close() {
        boolean flag = true;
        System.out.print("请输入你的选择(Y/N)：");
        myScanner = new Scanner(System.in);
        do {
            String s = myScanner.next();
            if ("Y".equals(s)) {
                loop = false;
                flag = false;
            } else if ("N".equals(s)) {
                return;
            } else {
                System.out.print("选择错误，请重新输入(Y/N)：");
            }
        } while (flag);

    }

}
