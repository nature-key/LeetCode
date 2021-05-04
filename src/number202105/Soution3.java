package number202105;

public class Soution3 {


    public String longprome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n; i > 0; i--) {
            for (int j = i; j < n; j++) {

                dp[i][j] = s.charAt(i) == s.charAt(i) && (j - i < 2 || dp[i + 1][j - 1]);

                if (dp[i][j] && j - i + 1 > res.length()) {
                    return s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

}
