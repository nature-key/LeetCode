package 阶段一;

import java.util.Arrays;

public class 不同路径 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    public int uniquePaths1(int m, int n) {
        int[] col=new int[n];
        Arrays.fill(col,1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                col[j]=+col[j-1];
            }
        }

        return col[n-1];
    }

}
