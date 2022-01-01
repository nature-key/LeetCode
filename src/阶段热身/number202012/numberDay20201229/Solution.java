package 阶段热身.number202012.numberDay20201229;

import java.util.Arrays;

public class Solution {

    private static int minCount(int[] cons, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < cons.length; j++) {
                if (cons[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - cons[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];

    }

    ;

    public static void main(String[] args) {
        int[] cons = {1, 2, 5};
        int amount = 11;

        System.out.println(minCount(cons, amount));
    }
}
