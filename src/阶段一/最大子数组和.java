package 阶段一;

import java.util.Arrays;

public class 最大子数组和 {


    public int maxSubArray(int[] nums) {

        int[] dp = nums;

        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(nums[i]+0,nums[i]+dp[i-1]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
