package number202103.numberDay20210310;

import java.util.Arrays;

public class Solution {


    private static  int unPath(int m,int n){
        int[][] dp =new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int j = 0; j < m; j++) {
            dp[j][0]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    private static  int path(int m,int n){
        int []col =new int[n];
        Arrays.fill(col,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                col[j]=col[j]+col[j-1];
            }
        }
        return col[n-1];
    }

    public static void main(String[] args) {
        System.out.println(unPath(3, 7));
        System.out.println(path(3, 7));
    }


}
