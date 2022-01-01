package 阶段热身.number202101.numberDay20210101;

public class Solution {


    private static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] =1+ Math.min(
                            Math.min(dp[i - 1][j - 1], dp[i][j-1]),
                            dp[i-1][j]
                    );
                }
            }

        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1="horse";
        String word2="ros";
        System.out.println(minDistance(word1, word2));
    }

}
