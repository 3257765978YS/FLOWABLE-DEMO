package LeetCode;

import java.util.*;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/7/14 15:33
 */
public class YsTest {
    public static void main(String[] args) {
//        LeetCode.Solution8 solution8=new LeetCode.Solution8();
        /*Solution10 solution10=new Solution10();
        Solution11 solution11=new Solution11();
//        int[] nums={1,3,5,6};
//        System.out.println(solution8.searchInsert(nums,7));
//        System.out.println(solution10.SearchInsert(nums,5));

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = solution10.merge(intervals);
        System.out.println(solution11.merge(intervals));
        System.out.println(Arrays.toString(res));
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(Arrays.toString(res[i]));
//        }


         */
/*
        Solution12 solution12 = new Solution12();
        System.out.println(solution12.lengthOfLongestSubstring("abcabcbb"));
        Solution13 solution13 = new Solution13();
        int[] n1 = {1,3};
        int[] n2 = {2};

        System.out.println(solution13.findMedianSortedArrays(n1,n2));

 */
//        System.out.println(new Solution14().reverse(314748364));
        System.out.println(new Solution14().reverse(1463847412));
//        System.out.println(Integer.MAX_VALUE / 10);
    }
}
class Solution8 {
    public int searchInsert(int[] nums, int target) {
        int a=nums.length;
        for(int i=0;i<a;i++){
            if(nums[i]==target){
                return i;
            }
            for(int j=i;j<a;j++){
                if(j+1==a){
                    if(nums[j]<target){
                        return j+1;
                    }else{
                        return 0;
                    }
                }
                if(nums[i]<target && nums[j+1]>target){
                    return j+1;
                }else if(nums[i]<target && nums[j+1]<target){
                    continue;
                }else if(nums[i]<target && nums[j+1]==target){
                    return j+1;
                }else{
                    return 0;
                }
            }
            return a;
        }
        return a;
    }
}
class Solution9 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

class Solution10{
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        //这里先进行一个排序，比较的大小是每个数组的第一位
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        //定义一个list去装数组，等后面在转化
        List<int[]> res = new ArrayList<>();
        //先给定一个初始的值，就取数组里最小的第一个
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            //这里主要是判断去取倒数第一位数组的值
            //因为前面是已经排序好了的数组
            int[] ints = res.get(res.size() - 1);
            /*
             * 其实这里只需要两个判断，一个是判断第一个数组的最后一位是否
             * 在第二个数组的第一位大，如果大肯定是需要重叠判断；
             * 如果小的话，直接加到list里面，继续第二次循环
             * 举个栗子：
             * [1,3] 和 [2,4] ,这个是需要重合判断的
             * [1,3] 和 [5,7]，这个是不需要比较的
             * */
            if (ints[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else if (ints[1] < intervals[i][1]) {
                ints[1] = intervals[i][1];
            }

        }

        return res.toArray(new int[res.size()][2]);
    }
}
class Solution11{
    public int[][] merge(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);
        int count = 0;
        int[][] res = new int[intervals.length][2];
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];
        for (int idx = 1; idx < intervals.length; idx++) {
            if (res[count][1] < intervals[idx][0]) {
                count++;
                res[count][0] = intervals[idx][0];
                res[count][1] = intervals[idx][1];
            }
            if (res[count][1] >= intervals[idx][0] && res[count][1]<intervals[idx][1]){
                res[count][1] = intervals[idx][1];
            }

        }

        return Arrays.copyOfRange(res, 0, count + 1);
    }

    //快排
    private void quickSort(int[][] intervals, int start, int end) {
        if (start >= end) return;
        int midVal = intervals[start][0];

        int i = start, j = end;
        while (i < j) {
            while (intervals[j][0] > midVal && i < j) j--;
            while (intervals[i][0] <= midVal && i < j) i++;
            //交换
            if (i == j) break;
            for (int idx = 0; idx < 2; idx++) {
                int tmp = intervals[i][idx];
                intervals[i][idx] = intervals[j][idx];
                intervals[j][idx] = tmp;
            }
        }
        int midIdx = i;
        for (int idx = 0; idx < 2; idx++) {
            int tmp = intervals[midIdx][idx];
            intervals[midIdx][idx] = intervals[start][idx];
            intervals[start][idx] = tmp;
        }
        quickSort(intervals, start, midIdx - 1);
        quickSort(intervals, midIdx + 1, end);
    }
}

/**
 * 3 无重复字符的最长子串
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
class Solution12 {
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}

/**
 * 4. 寻找两个正序数组的中位数
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 */
class Solution13{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {

                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0; //i为nums1的个数指针，表第i个   j为nums2的个数指针 表第j个
        while (count != (m + n)) {
            if (i == m) { // i = 0 ,j = 0,m = 2 ,n = 1
                         // i = 1, j = 0, m = 2 , n = 1
                        // i = 1, j = 1, m = 2 , n = 1
                //若nums1遍历完成时，nums2未遍历完，则依次遍历出nums2赋值给nums
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) { // 0 = 1 ?
                //若nums2遍历完成时，nums1未遍历完，则依次遍历出nums2赋值给nums
                while (i != m) { // i = 0 ,j = 0,m = 2 ,n = 1
                                // i = 1, j = 0, m = 2 , n = 1
                               // i = 1, j = 1, m = 2 , n = 1
                    nums[count++] = nums1[i++];
                }
                break;
            }

            //比较两个数组当前下标数的大小，较小的一方赋值给nums
            if (nums1[i] < nums2[j]) {  // nums1=[1,3]   nums2=2
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        //进行奇偶判断，然后求出中位数
        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }
}

/**
 * 7. 整数反转
 * 输入：x = 123
 * 输出：321
 * 注：如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 */
class Solution14 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {

                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

}





