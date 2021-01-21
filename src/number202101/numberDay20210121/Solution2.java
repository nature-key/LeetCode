package number202101.numberDay20210121;

public class Solution2 {


    /**
     * dp[i] 第i节 需要几步
     * @param n -
     * @return
     */
    private static  int getMax(int n){
        int []dp =new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <=n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    private static  int getMax1(int n){
        int []dp =new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(getMax(40));
        System.out.println(getMax1(40));
    }
}
