package 阶段一;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class 求众数 {

    /**
     * 计数
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        int limit = nums.length >> 1;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > limit) {
                return entry.getKey();
            }
        }
        return -1;
    }


    public int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }


}
