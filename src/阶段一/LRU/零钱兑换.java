package 阶段一.LRU;

import java.util.Arrays;

public class 零钱兑换 {


    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i -coins[j]]+1,dp[i]);
                }

            }
        }

        return dp[amount]>amount?-1:dp[amount];

    }
}
