package 阶段热身.number202012.numberDay20201224;

public class Solution {


    private static int maxProduct(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][2];
        dp[0][0] = num[0];//max
        dp[0][1] = num[0];//min
        int res = num[0];
        for (int i = 1; i < num.length; i++) {
            int value = num[i];
            int x = i % 2;
            int y = (i - 1) % 2;
            dp[x][0] = Math.max(Math.max(dp[y][0] * value, dp[y][1] * value), value);
            dp[x][1] = Math.min(Math.min(dp[y][0] * value, dp[y][1] * value), value);
            res = Math.max(dp[x][0], res);
        }
        return res;
    }

    ;

    private static int maxProduct2(int[] num) {

        if (num.length == 0) {
            return 0;
        }

        int max = num[0];
        int min = num[0];
        int res = num[0];
        for (int i = 1; i < num.length; i++) {
            int value = num[i];
            max = Math.max(Math.max(max * value, min * value), value);
            min = Math.min(Math.min(min * value, max * value), value);
            res = Math.max(max, res);
        }
        return res;
    }

    ;


    public static void main(String[] args) {
        int[] num = {-2,0,-1};
        System.out.println(maxProduct(num));
        System.out.println(maxProduct2(num));
    }
}
