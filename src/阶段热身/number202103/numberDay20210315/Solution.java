package 阶段热身.number202103.numberDay20210315;

public class Solution {


    private static  int MaxLength(String s1,String s2){

        int m = s1.length();
        int n=s2.length();

        if(m==0||n==0){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                 dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1="abcde";
        String s2="ace";

        System.out.println(MaxLength(s1, s2));
    }

}
