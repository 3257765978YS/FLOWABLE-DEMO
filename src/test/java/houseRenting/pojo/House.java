package houseRenting.pojo;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/10 14:33
 */
public class House {
    /**
     * 房主姓名
     */
    private String household;
    /**
     * 电话
     */
    private String phone;
    /**
     * 地址
     */
    private String address;
    /**
     * 月租
     */
    private int monthlyPay;
    /**
     * 状态（已出租/未出租）
     */
    private String state;


    public House(String household, String phone, String address, int monthlyPay, String state) {
        this.household = household;
        this.phone = phone;
        this.address = address;
        this.monthlyPay = monthlyPay;
        this.state = state;
    }

    public String getHousehold() {
        return household;
    }

    public void setHousehold(String household) {
        this.household = household;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(int monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
