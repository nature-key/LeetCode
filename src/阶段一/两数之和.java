package 阶段一;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两数之和 {

    /**
     * hash表
     * 思路就是 target-num[i] 就是第二值的数字
     * 1.判断集合中是否存在tartget-nums[i]
     * 2.不存在就放到集合
     * 3.存在，就说明可以找到合适的值，直接返回targe-nums[i]在map中的下表，和当前下表
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoNums(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i])) {
                return new int[]{result.get(target - nums[i]), i};
            }
            result.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int tartget = 9;
        System.out.println(Arrays.toString(twoNums(nums, tartget)));
    }

    public int[] getTwoSum(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return a;
    }


    public int[] getTwoNums(int[] nums ,int tartget){
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int emement=tartget-nums[i];
            if (map.containsKey(emement)) {
                return new int[]{map.get(emement),i};
            }
            map.put(nums[i],i);
        }

        return new int[0];
    }


}
