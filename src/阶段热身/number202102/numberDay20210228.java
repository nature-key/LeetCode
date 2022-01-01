package 阶段热身.number202102;

import java.util.Arrays;

public class numberDay20210228 {


    /**
     * 分饼干
     *
     * @param g 孩子的胃口
     * @param s 饼干的大小
     * @return
     */
    private static int getConentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childrenNums = g.length;
        int cookieNums = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < childrenNums && j < cookieNums; i++, j++) {
            while (j < cookieNums && g[i] > s[j]) {
                j++;
            }
            if (j < cookieNums) {
                count++;
            }
        }
        return count;
    }

    public static int getConentChildren1(int [] g,int [] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int childrenNums = g.length;
        int cookieNums = s.length;
        int count = 0;

        for (int i = 0, j = 0; i < childrenNums && j < cookieNums; i++) {
           if(g[i]<=s[j]){
               count++;
               j++;
           }else {
               j++;
           }
        }
        return count;
    }


    /**
     * 动态规划
     * dp[i] i的金额最少的硬币树
     * dp[i]=min(dp[0]到dp[i-1])+1 代表从0到dp[i-1] 之间最小值 加上这一次的硬币
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <=amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]) + 1;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    private static  int maxPrice(int[]prices){

        int maxPrice=0;

        for (int i = 0; i < prices.length; i++) {
            if(prices[i+1]>prices[i]){
                maxPrice+=prices[i+1]-prices[i];
            }
        }
        return maxPrice;
    }

    /**
     * 贪心算法
     * 记录最后一位下表
     * 倒序遍历 每一个元素 加上下表
     * 如果结果大于你记录的最后一位下标 就是说明可以调到结尾位置
     * @param nums
     * @return
     */
    private static  boolean canJump(int[] nums){
        if (nums==null) {
            return false;
        }
        int endIndex=nums.length-1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i]+i>=endIndex){
                endIndex=i;
            }
        }
        return endIndex==0;
    }

    public static void main(String[] args) {
//        int[] g = {1, 2, 3};
//        int[] s = {1, 1};
//        System.out.println(getConentChildren(g, s));
//        int [] conins={1,2,5};
//        int amount=11;
//        System.out.println(coinChange(conins, amount));
        int [] nums={2,3,1,1,4};
        System.out.println(canJump(nums));


    }
}
