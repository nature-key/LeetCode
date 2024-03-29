package 阶段一;

import java.util.Map;

public class 乘积最大子数组 {

    /**
     * https://leetcode-cn.com/problems/maximum-product-subarray/solution/dong-tai-gui-hua-li-jie-wu-hou-xiao-xing-by-liweiw/
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int length = nums.length;
        if(length<=0){
            return 0;
        }
        int[][] dp = new int[length][2];
        dp[0][1]=nums[0];
        dp[0][0]=nums[0];
        for (int i = 1; i < length; i++) {
            if(nums[i]>0){
                dp[i][1]=Math.max(dp[i-1][1]*nums[i],nums[i]);
                dp[i][0]=Math.max(dp[i-1][0]*nums[i],nums[i]);
            }else{
                dp[i][1]=Math.max(dp[i-1][0]*nums[i],nums[i]);
                dp[i][0]=Math.max(dp[i-1][1]*nums[i],nums[i]);
            }

        }
        int res= dp[0][1];
        for (int i = 1; i < length; i++) {
            res=Math.max(dp[i][1],res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};

        System.out.println(maxProduct(nums));
    }




    public int maxProduct1(int[] nums) {

        int length = nums.length;
        if(length<=0){
            return 0;
        }
        int [][] dp = new int[nums.length][2];

        dp[0][1]=nums[0]; //最大乘积和
        dp[0][0]=nums[0];//最小乘积和
        for (int i = 1; i < nums.length; i++) {

            if(nums[i]>0){
                dp[i][1]=Math.max(dp[i-1][1]*nums[i],nums[i]);
                dp[i][0]=Math.min(dp[i-1][0]*nums[i],nums[i]);
            }else{
                dp[i][1]= Math.max(dp[i-1][0]*nums[i],nums[i]);
                dp[i][0]=Math.min(dp[i-1][1]*nums[i],nums[i]);
            }
        }
        int res=0;
        for (int i = 0; i < dp.length; i++) {
            res=Math.max(res,dp[i][1]);
        }
    return res;

    }
}
