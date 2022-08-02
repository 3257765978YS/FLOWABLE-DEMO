package LeetCode.practice;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : 杨帅
 * @description:  1124. 表现良好的最长时间段
 * @date： 2021/10/27 16:11
 */
public class Homework06 {
    public static void main(String[] args) {
        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        int i = longestWPI(hours);
        System.out.println(i);
    }

    public static int longestWPI(int[] hours) {

        //方案一：暴力方法 时间复杂度 O(N^2)
        
//        int n = hours.length;
//        int[] a = new int[n];
//        int sum = 0;
//        int max = 0;
//
//        for (int i = 0; i < n; i++) {
//
//            if (hours[i] > 8) {
//
//                a[i] = -1;
//            } else {
//
//                a[i] = 1;
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//
//            for (int j = i; j < n; j++) {
//
//                sum += a[j];
//                if (sum < 0) {
//
//                    max = Math.max(max, j - i + 1);
//                }
//            }
//            sum = 0;
//        }
//        return max;

        //方案二 ：前缀和+单调栈 时间复杂度O(N)
        int n = hours.length;
        int[] score = new int[n];
        for (int i=0;i<n;i++) score[i] = hours[i] > 8 ? 1 : -1;

        int[] presum = new int[n + 1];
        presum[0] = 0;
        for (int i=1;i<n+1;i++) presum[i] = presum[i - 1] + score[i - 1];

        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);
        for (int i=1;i<n;i++) {
            if (stack.isEmpty() || presum[stack.peekLast()] > presum[i]) {
                stack.addLast(i);//栈中索引指向的元素严格单调递减
            }
        }
        for (int i=n;i>=0;i--) {//从后往前遍历 presum 数组
            while(!stack.isEmpty() && presum[i] > presum[stack.peekLast()]) {//说明栈顶索引到i位置的和是大于0的，是表现良好的时间段
                result = Math.max(result, i - stack.pollLast());//与栈顶索引指向元素比较，如果相减结果大于 0，则一直出栈，直到不大于 0 为止，然后更新当前最大宽度
            }
        }
        return result;
    }
}
