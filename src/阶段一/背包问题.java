package 阶段一;

public class 背包问题 {

    /**
     * @param V      容量
     * @param N      第几件
     * @param weight 重量
     * @param value  价值
     * @return
     */
    public static String ZeroOnePack(int V, int N, int[] weight, int[] value) {

        int[][] dp = new int[N + 1][V + 1];
        /**
         * dp[i][j] 在第i件商品的时候剩余j容量的书包，时候的最大利润
         *  如果 在第i件商品的重量大于数据剩余容量，则没有办法拿，就是dp[i][j]=dp[i-1][j]
         *  否则
         *      第i件商品拿 dp[i][j]=dp[i-1][j-weigth[i-1]]+value[i-1];
         *      第i件商品不拿 dp[i][j]=dp[i-1][j]
         */
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < V; j++) {
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }

        int maxValue = dp[N][V];
        int j = V;
        String numstr = "";
        for (int i = N; i > 0; i--) {
            if (dp[i][j] > dp[i - 1][j]) {
                numstr = numstr + " " + i;
                j = j - weight[i - 1];
            }
            if (j == 0) {
                break;
            }
        }
        return numstr;

    }

}
