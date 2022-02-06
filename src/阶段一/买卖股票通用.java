package 阶段一;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/javayi-ge-si-lu-da-bao-suo-you-gu-piao-t-pd1p/
 */
public class 买卖股票通用 {

    public static  int maxProfit(int K, int[] prices) {
        int n = prices.length;
        int [][][] dp = new int[n][2][K+1];
        for (int k = 0; k <=K; k++) {
            dp[0][0][k]=0;
            dp[0][1][k]=-prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= K; k++) {
                //交易次数，每次交易包含买入和卖出 这里记录买入才会记录一次交易
                dp[i][0][k]=Math.max(dp[i-1][0][k],dp[i-1][1][k]+prices[i]);
                dp[i][1][k]=Math.max(dp[i-1][1][k],dp[i-1][0][k-1]-prices[i]);
            }
        }
        return dp[n-1][0][K];
    }

    public static void main(String[] args) {
        int [] prices={3,2,6,5,0,3};
        int k=2;
        System.out.println(maxProfit(k, prices));
    }
}
