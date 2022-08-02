package LeetCode;

import java.util.Arrays;
import java.util.List;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/7/12 10:30
 */
public class AlgorithmTest {
    public static void main(String[] args) {
//        LeetCode.Solution solution=new LeetCode.Solution();
//        System.out.println(solution.minDistance("apple","airplane"));
//        LeetCode.Solution1 solution=new LeetCode.Solution1();
//        String[] num="7,1,5,3,6,4".split(",");
//        List<Integer> profit = new ArrayList<>();
//        for (String s : num) {
//            Integer s1 = Integer.valueOf(s);
//            profit.add(s1);
//        }
//        System.out.println(solution.maxProfit(profit));
//        LeetCode.Solution2 solution2=new LeetCode.Solution2();
//        LeetCode.Solution3 solution3=new LeetCode.Solution3();
//        List<Integer>list=new ArrayList<>();
//        String[] coins="1,2,5".split(",");
//        for (String coin : coins) {
//            list.add(Integer.parseInt(coin));
//        }
//        System.out.println(solution3.coinChange(list,11));
//        System.out.println(solution2.superEggDrop(4,10));
//        LeetCode.Solution4 solution4=new LeetCode.Solution4();
//        System.out.println(solution4.waysToChange(100));
//        LeetCode.Solution5 solution5=new LeetCode.Solution5();
//        System.out.println(solution5.uniquePaths(10,10));
//        LeetCode.Solution6 solution6=new LeetCode.Solution6();
//        System.out.println(solution6.uniquePathsWithObstacles(new int[8][4]));
        Solution7 solution7=new Solution7();
        System.out.println(solution7.numSquares(11));
    }
}
class Pwd {
    public boolean checkPwd(String password) {
        int upperNum = 0; //大写字母个数
        int lowerNum = 0; //小写字母个数
        int intNum = 0;  //数字个数
        int otherNum = 0; //字符个数
        for (int i = 0; i < password.length(); i++) {
            //判断大写字母
            if ((int) password.charAt(i) > 64 && (int) password.charAt(i) < 91) {
                upperNum = upperNum + 1;
            }
            //判断小写字母
            else if ((int) password.charAt(i) > 96 && (int) password.charAt(i) < 123) {
                lowerNum = lowerNum + 1;
            }
            //判断数字
            else if ((int) password.charAt(i) > 47 && (int) password.charAt(i) < 58) {
                intNum = intNum + 1;
            }
            //判断其他字符个数
            else {
                otherNum = otherNum + 1;
            }
        }
        if (upperNum == 0 || lowerNum == 0 || intNum == 0 || otherNum == 0 || password.length() < 8) {
            return false;
        }
        return true;
    }
}
class Solution {
    private int m, n;
    private int[][] dp;
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null)
            return 0;
        m = word1.length();
        n = word2.length();
        dp = new int[m][n];
        return dfs(0, 0, word1, word2);
    }
    private int dfs(int i, int j, String word1, String word2) {
        if (i == m) // i先到达，只能填充word2剩下的字符
            return n - j;
        if (j == n) // j先到达，只能删除word1剩下的字符
            return m - i;
        if (dp[i][j] > 0) // 记忆化
            return dp[i][j];
        int change = 0; // [i:]与[j:]后面编辑的最少次数
        if (word1.charAt(i) == word2.charAt(j))
            change = dfs(i + 1, j + 1, word1, word2);
        else {
            // 插入
            change = dfs(i, j + 1, word1, word2) + 1;
            // 删除
            change = Math.min(change, dfs(i + 1, j, word1, word2) + 1);
            // 替换
            change = Math.min(change, dfs(i + 1, j + 1, word1, word2) + 1);
        }
        // 回溯到这里，再记忆化子问题
        return dp[i][j] = change;
    }
}
class Solution1 {
    public int maxProfit(List<Integer> prices) {
        int len, minVal, res = 0;
        if (prices == null || (len = prices.size()) == 0)
            return 0;
        minVal = prices.get(0);
        for (int i = 1; i < len; i++) {
            res = Math.max(res, prices.get(i) - minVal);
            minVal = Math.min(minVal, prices.get(i));
        }
        return res;
    }
}
class Solution2 {
    private int[][] dp;
    public int superEggDrop(int K, int N) {
        dp = new int[K + 1][N + 1];
        return dfs(K, N);
    }
    // K表示鸡蛋个数，N表示楼层数
    private int dfs(int K, int N) {
        if (K == 1) // 当只有一个鸡蛋时，最坏尝试次数为 N
            return N;
        if (N <= 1) // 当楼层数少于2时，最坏尝试次数肯定是0或1，直接返回 N
            return N;
        if (dp[K][N] > 0) // 记忆化搜索
            return dp[K][N];
        int lt = 1, rt = N, res = N, mid, broken, nobroken;// 当前楼层最坏情况下，至多需要尝试N次
        // dfs(K - 1, mid - 1)和dfs(K, N - mid)是一个交叉线性函数，因此可用二分解法
        while (lt <= rt) {
            mid = (lt + rt) >> 1; // 尝试在第mid层楼下仍鸡蛋
            broken = dfs(K - 1, mid - 1); // 碎
            nobroken = dfs(K, N - mid); // 不碎
            if (broken > nobroken) {
                rt = mid - 1;
                res = Math.min(res, broken + 1); // 取最高点
            } else {
                lt = mid + 1;
                res = Math.min(res, nobroken + 1); // 取最高点
            }
        }
        return dp[K][N] = res;
    }
}

class Solution3 {
    public int coinChange(List<Integer> coins, int amount) {
        int len;
        if (coins == null || (len = coins.size()) == 0)
            return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0; // 组成金额为0需要用0个硬币
        for (int i = 0; i < len; i++) {
            for (int j = coins.get(i); j <= amount; j++) // 正序枚举，以重复使用元素
                dp[j] = Math.min(dp[j], dp[j - coins.get(i)] + 1);
        }
        return dp[amount] < 0x3f3f3f3f ? dp[amount] : -1;
    }
}
class Solution4 {
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coins = new int[] { 1, 5, 10, 25 };
        dp[0] = 1; // 注意初始化为1，即组成钱0的方案数为1
        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= n; j++)
                dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
        return dp[n];
    }
}

class Solution5 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
class Solution6 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] > 0)
                    continue;
                if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else if (i == 0)
                    dp[i][j] = dp[i][j - 1];
                else if (j == 0)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
class Solution7 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 10);
        dp[0] = 0; // 使用0个完全平方数构成元素0
        // 只需枚举 根号 n 个数即可
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) // 正序枚举，因为每个完全平方数可重复被使用
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
        }
        return dp[n];
    }
}


