package LeetCode.practice;

/**
 * @author : 杨帅
 * @description: 496. 下一个更大元素 I
 * @date： 2021/10/27 09:10
 */
public class Homework01 {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] ints = nextGreaterElement(nums1, nums2);
        for (int anInt : ints) {
            System.out.print(" " +anInt);
        }
//        System.out.println(ints);
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        int n = nums1.length, m = nums2.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < m && nums1[i] != nums2[j]) j++;
            while (j < m && nums1[i] >= nums2[j]) j++;
            ans[i] = j < m ? nums2[j] : -1;
        }
        return ans;
    }
}
