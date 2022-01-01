package 阶段热身.number202010.numberDay20201018;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public static int[] sum( int[] num,int target){

        int[] result =new int[2];
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                if (num[i]+num[j]==target) {
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;

    }

    public  static int[] sum2(int[] nums,int target){
        Map<Integer,Integer> map =new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return  new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int [] nums = {2, 11, 15,7};
        int target=9;
        int[] sum = sum(nums, target);
        int[] sum2 = sum2(nums, target);
        System.out.println(Arrays.toString(sum));
        System.out.println(Arrays.toString(sum2));
    }

}
