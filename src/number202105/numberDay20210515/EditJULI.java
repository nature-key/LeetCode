package number202105.numberDay20210515;

public class EditJULI {


    private int minDistanc(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < m + 1 ; i++) {
            dp[0][i] = i;
        }

        for (int j = 1; j < n + 1; j++) {
            dp[j][0] = j;
        }
        //n+1=6
        for (int i = 1; i <n + 1; i++) {
            char c = word1.charAt(i-1);
            for (int j = 1; j < m + 1; j++) {
                char c1 = word2.charAt(j-1);
                if (c == c1) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1])+1;
                }
            }

        }

        return dp[n][m];
    }


    public static void main(String[] args) {
        EditJULI juli = new EditJULI();
        System.out.println(juli.minDistanc("intention", "execution"));
    }

}
