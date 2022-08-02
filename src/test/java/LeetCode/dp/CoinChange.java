package LeetCode.dp;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/26 11:01
 */
public class CoinChange {
    private static final int INF = 987654321;

    public static int coinChange(int[] coins, int amount) {

        if (coins == null) throw new IllegalArgumentException("Coins array is null");
        if (coins.length == 0) throw new IllegalArgumentException("No coin values :/");

        final int N = coins.length;
        // Initialize table and set first row to be infinity
        int[][] dp = new int[N + 1][amount + 1];
        java.util.Arrays.fill(dp[0], INF);
        dp[1][0] = 0;

        // Iterate through all the coins
        for (int i = 1; i <= N; i++) {

            int coinValue = coins[i - 1];
            for (int j = 1; j <= amount; j++) {

                // Consider not selecting this coin
                dp[i][j] = dp[i - 1][j];

                // Try selecting this coin if it's better
                if (j - coinValue >= 0 && dp[i][j - coinValue] + 1 < dp[i][j]) {
                    dp[i][j] = dp[i][j - coinValue] + 1;
                }
            }
        }
        //dp[0] = 0
        // dp[1] = 1
        // dp[2] = 2
        // dp[3] = min{dp[2]+1,dp[1]+1} = 2
        // dp[4] = min{dp[3]+1,dp[2]+1} = 3
        // dp[5] = min{dp[4]+1,dp[3]+1} = 3
        // dp[6] = min{dp[5]+1,dp[4]+1 ,dp[0]+1} = 1
        // dp[7] = min{dp[6]+1,dp[5]+1, dp[1]+1} = 2
        // dp[8] = min{dp[7]+1,dp[6]+1, dp[2]+1} = 3
        // dp[9] = min{dp[8]+1,dp[7]+1, dp[3]+1} = 3
        // dp[10] = min{dp[9]+1,dp[8]+1, dp[4]+1} = 4
        // dp[11] = min{dp[10]+1,dp[9]+1 ,dp[5]+1} = 4
        // dp[12] = min{dp[11]+1,dp[10]+1, dp[6]+1} = 2
        // dp[13] = min{dp[12]+1,dp[11]+1, dp[7]+1} = 3
        // dp[14] = min{dp[13]+1,dp[12]+1, dp[8]+1} = 3
        // dp[15] = min{dp[14]+1,dp[13]+1, dp[9]+1} = 4
        // dp[16] = min{dp[15]+1,dp[14]+1 ,dp[10]+1} = 4
        // dp[17] = min{dp[16]+1,dp[15]+1, dp[11]+1} = 5

        // The amount we wanted to make cannot be made :/
        if (dp[N][amount] == INF) return -1;

        // Return the minimum number of coins needed
        return dp[N][amount];
    }

    public static int coinChangeSpaceEfficient(int[] coins, int amount) {

        if (coins == null) throw new IllegalArgumentException("Coins array is null");

        // Initialize table and set everything to infinity except first cell
        int[] dp = new int[amount + 1];
        java.util.Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coinValue : coins) {
                if (i - coinValue >= 0 && dp[i - coinValue] + 1 < dp[i]) {
                    dp[i] = dp[i - coinValue] + 1;
                }
            }
        }

        // The amount we wanted to make cannot be made :/
        if (dp[amount] == INF) return -1;

        // Return the minimum number of coins needed
        return dp[amount];
    }

    // 递归方法的优点是它不必访问
    //所有可能的状态都像表格方法一样。这可以加快速度
    //特别是如果硬币面额很大的话。
    public static int coinChangeRecursive(int[] coins, int amount) {

        if (coins == null) throw new IllegalArgumentException("Coins array is null");
        if (amount < 0) return -1;

        int[] dp = new int[amount + 1];
        return coinChangeRecursive(amount, coins, dp);
    }

    // Private helper method to actually go the recursion
    private static int coinChangeRecursive(int amount, int[] coins, int[] dp) {

        // Base cases.
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (dp[amount] != 0) return dp[amount];

        int minCoins = INF;
        for (int coinValue : coins) {

            int newAmount = amount - coinValue;
            int value = coinChangeRecursive(newAmount, coins, dp);
            if (value != -1 && value < minCoins) minCoins = value + 1;
        }

        // If we weren't able to find some coins to make our
        // amount then cache -1 as the answer.
        return dp[amount] = (minCoins == INF) ? -1 : minCoins;
    }

    public static void main(String[] args) {
        int[] coins = {2, 6, 1};
        System.out.println(coinChange(coins, 17));
        System.out.println(coinChangeSpaceEfficient(coins, 17));
        System.out.println(coinChangeRecursive(coins, 17));
    }
}
