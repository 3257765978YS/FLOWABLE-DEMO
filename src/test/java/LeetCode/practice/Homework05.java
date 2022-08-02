package LeetCode.practice;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/27 14:04
 */
public class Homework05 {
    public static void main(String[] args) {

        int i = new Solution2().numberOfRounds("00:47", "00:57");
        System.out.printf("玩了%d局", i);
    }
}

class Solution2 {
    public int numberOfRounds(String startTime, String finishTime) {
        int startH = Integer.parseInt(startTime.split(":")[0]);
        int startM = Integer.parseInt(startTime.split(":")[1]);
        int finishH = Integer.parseInt(finishTime.split(":")[0]);
        int finishM = Integer.parseInt(finishTime.split(":")[1]);
        // 计算小时和分钟数
        int hours = 0;
        int minutes = 0;
        // 如果结束时间小于开始时间, 或者结束时间与开始时间相同的情况下, 开始分钟大于结束分钟, 那么就补上 24 小时.
        if (finishH < startH || (finishH == startH && startM > finishM)) hours = finishH + 24 - startH;
            // 否则直接相减就是时间差
        else hours = finishH - startH;
        // 计算分钟差
        minutes =  finishM / 15 - (startM + 14) / 15;
        // 两者相加得到最终答案
        int ans = hours * 4 + minutes;
        return ans;
    }

}
