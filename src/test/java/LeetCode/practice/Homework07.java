package LeetCode.practice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author : 杨帅
 * @description: 1. 两数之和
 * @date： 2021/10/29 11:01
 */
public class Homework07 {
    public static void main(String[] args) {
        int[] nums = {4, 2, 6,5,8,10,17,13,11};
        TimeUnit time = TimeUnit.MILLISECONDS;
        long start = time.toNanos(new Date().getTime());
        int[] ints = twoSum(nums, 28);
        long end1 = time.toNanos(new Date().getTime());
        int[] ints2 = forceTwoSum(nums, 28);
        long end2 = time.toNanos(new Date().getTime());
        for (int anInt : ints) {
            System.out.print("\t" + anInt);
        }
        System.out.println();
        for (int anInt : ints2) {
            System.out.print("\t" + anInt);
        }
        System.out.println();
        System.out.println("hashtable用时：" + (end1 - start)  + "ms");
        System.out.println("暴力循环用时：" + (end2 - end1) + "ms");
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static int[] forceTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}

