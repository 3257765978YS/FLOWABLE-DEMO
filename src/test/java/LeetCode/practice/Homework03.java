package LeetCode.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/27 10:12
 */
public class Homework03 {
    public static void main(String[] args) {

    }

    public static int findNumbers(int[] nums) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int s =0;
        if(sb.toString().indexOf(String.valueOf(s))>=0){

        }
        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len ; i++){
            if(String.valueOf(nums[i]).length() % 2 ==0){
                count ++;
            }
        }
        return count;
    }

}

