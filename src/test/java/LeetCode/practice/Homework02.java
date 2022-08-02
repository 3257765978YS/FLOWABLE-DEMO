package LeetCode.practice;

import java.util.Random;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/27 09:57
 */
public class Homework02 {
    public static void main(String[] args) {
//        Solution obj = new Solution(rects);
    }
}
class Solution{
    int[][] rec;
    int len;
    int c[];
    public Solution(int[][] rects) {
        rec = rects;
        c = new int[rects.length+1];

        for(int i =0;i < rects.length; i++){
            c[i+1] += c[i] + (rec[i][2] - rec[i][0] + 1) * (rec[i][3] - rec[i][1] + 1);
        }
        len = c[c.length - 1];
    }
    Random r = new Random();
    public int[] pick() {
        int p = r.nextInt(len);
        int left = 1;
        int right = c.length - 1;
        while(left < right){
            int mid = (left + right) /2;
            if(p >= c[mid]){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        int res = p - c[left-1];
        int col = rec[left-1][3] - rec[left-1][1] + 1;
        return new int[] {res / col + rec[left-1][0],res % col + rec[left-1][1]};
    }
}
