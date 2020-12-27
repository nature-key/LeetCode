package number202012.numberDay20201227;

import java.util.Arrays;
import java.util.Vector;

public class Solution {

    /**
     * 动态规划
     * O(n^2)
     *
     * @param num
     * @return
     */
    private static int lengthOfLIS(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        int[] dp = new int[num.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 二分法
     *
     * @param num
     * @return
     */
    private static int lengthOfLIS2(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        Vector<Integer> v = new Vector<>();

        for (int i = 0; i < num.length; i++) {
            if (v.size() == 0 || v.get(v.size() - 1) < num[i]) {
                v.add(num[i]);
                continue;
            }

            int begin = 0;
            int end = v.size() - 1;
            int value = num[i];
            while (begin <= end) {
                int mid = begin + (end - begin) / 2;
                int valueMid = v.get(mid);
                if (valueMid > value) {
                    end = mid - 1;
                } else if (valueMid < value) {
                    begin = mid + 1;
                } else {
                    begin = mid;
                    break;
                }
            }

            v.set(begin, value);
        }

        return v.size();
    }

    public static void main(String[] args) {
        int[] num = {10, 9, 2, 5, 3, 7, 101, 18};
//        System.out.println(lengthOfLIS(num));
        System.out.println(lengthOfLIS2(num));
    }
}
