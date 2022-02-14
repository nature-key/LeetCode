package 阶段一;

public class 编辑距离 {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp =new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0]=i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j]=j;
        }
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        for (int n = 0; n <=len1; n++) {
            for (int m = 0; m <=len2; m++) {
                if(c1[n]==c2[m]){
                    dp[n][m]=dp[n-1][m-1];
                    continue;
                }
                int insert=dp[n][m-1]+1;
                int delete=dp[n-1][m]+1;
                int replace=dp[n-1][m-1]+1;

                dp[n][m]=Math.min(Math.min(insert,delete),replace);
            }
        }
        return dp[len1][len2];
    }
}
