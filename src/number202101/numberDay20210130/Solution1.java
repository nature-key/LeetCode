package number202101.numberDay20210130;

import java.util.Arrays;
import java.util.Stack;

public class Solution1 {


    private static int getMaxArea(int[] nums) {

        int maxArea = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                int minHeigth = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    minHeigth = Math.min(minHeigth, nums[k]);
                }
                maxArea = Math.max(maxArea, (j - i + 1) * minHeigth);
            }
        }
        return maxArea;
    }


    private static int getMaxArea2(int[] nums) {
        int maxArea = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int minHeigth = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                minHeigth = Math.min(minHeigth, nums[j]);
                maxArea = Math.max(maxArea, minHeigth * (j - i + 1));
            }
        }
        return maxArea;
    }


    private static int getMaxArea3(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * nums[i]);
        }
        return ans;

    }


    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        System.out.println(getMaxArea(nums));
        System.out.println(getMaxArea2(nums));
        System.out.println(getMaxArea3(nums));
    }

}
