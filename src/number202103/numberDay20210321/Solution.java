package number202103.numberDay20210321;

public class Solution {

    /**
     * dp[i][0] 代表到第房间不偷的最大金额
     * dp[i][1 ] 代表到第房间偷的最大金额
     *
     * @param nums
     * @return
     */
    private static int maxValue(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int length = nums.length;
        int[][] dp = new int[length][2];

        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[length - 1][0], dp[length - 1][1]);


    }

    private static int maxValue1(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int res = Math.max(dp[0], dp[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;


    }

}
