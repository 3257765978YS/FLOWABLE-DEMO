package demo;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/16 14:28
 */
public enum Week {
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"),
    THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六"),
    SUNDAY("星期日");
    private String dayName;

    Week(String dayName) {
        this.dayName = dayName;
    }

    @Override
    public String toString() {
        return dayName;
    }
}
