package 阶段热身.number202103.numberDay20210320;

import java.util.Arrays;

public class Solution  {


    private static  int maxValue(int[] nums){

        int[] dp = nums;

        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);

        }

        return Arrays.stream(dp).max().getAsInt();

    }

    private static  int MulitMax(int [] nums){
        int maxf=nums[0];
        int minf=nums[0];
        int res=nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxf=Math.max(maxf*nums[i],Math.max(nums[i],minf*nums[i]));
            minf=Math.min(minf*nums[i],Math.min(nums[i],maxf*nums[i]));
            res=Math.max(maxf,res);
        }
        return res;

    }


    private static  int coinChange(int[]coin,int amount){

        int max=amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0]=0;
        for (int i = 1; i <=amount; i++) {
            for (int j = 0; j < coin.length; j++) {
                if(coin[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coin[j]]+1);
                }
            }

        }
        return dp[amount]==max?-1:dp[amount];
    }


    public static void main(String[] args) {
//        int[] dp ={-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(maxValue(dp));
//        int [] dp ={-2,0,-1};
//        System.out.println(MulitMax(dp));

        int [] coin={1,2,5};
        int amount=11;
        System.out.println(coinChange(coin, amount));

    }
}
