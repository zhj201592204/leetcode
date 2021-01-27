package bookOne.algorithmImpl;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
 * (结果可能会很大，你需要将结果模上1000000007)
 */
public class Subject_43 {

    public int waysToChange(int n) {

        int[] dp = new int[n + 1];
        int[] coins = new int[]{1,5,10,25};
        //边界，一个硬币都不拿，凑0分
        dp[0] = 1;
        /**
         * 不选当前种类和选择一枚当前硬币
         * dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i])
         *
         * dp方程：dp[i] += dp[i - coin];
         *
         * 这里等式右边的dp[i]实际是上一时刻的dp
         * 如下理解
         * sum = 0;
         * sum = sum + 1;
         *
         * 从dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i])到 dp[i] = dp[i] + dp[i - coin]
         * 可以理解为，实际上dp[i-1]是上一时刻不使用当前种类硬币，所以两边直接压缩
         */
        for(int coin : coins) {
            for(int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }

}
