package 阶段一;

import java.util.Arrays;

public class 零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //这里使用amount+1是因为任何面值都不可能实现
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        //如果dp[amount]大于amount说明没有进行更新，因此找不到
        return dp[amount] > amount ? -1 : dp[amount];

    }
}
