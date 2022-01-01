package 阶段热身.number202102.numberDay20210221;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return pow(x, n);
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double half = pow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.myPow(2, 10));
        int[] nums = {1, 2, 3};
        System.out.println(solution.subsets(nums));
        System.out.println(solution.subsets1(nums));

    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> list, int index) {

        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        dfs(result, nums, list, index + 1);

        list.add(nums[index]);
        dfs(result, nums, list, index + 1);

        list.remove(list.size() - 1);

    }


    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            for (int i = 0, j = result.size(); i < j; i++) {
                List<Integer> list = new ArrayList<>(result.get(i));
                list.add(num);
                result.add(list);
            }
//            for (List<Integer> integers : result) {
//
//            }
        }

        return result;
    }


}
