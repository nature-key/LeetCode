package 阶段一;

import java.util.Arrays;

public class 最长递增子序列 {


    public static int lengthOfLIS(int[] nums) {

        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
