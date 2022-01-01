package 阶段热身.number202101.numberDay20210130;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {


    private static void SlipWindow(int[] nums,int k){
        List list = new ArrayList();
        for (int i = 0; i <=nums.length-k; i++) {
            int max=0;
            for (int j = 0; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            list.add(max);
        }

       list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        int [] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        SlipWindow(nums,k);
    }
}
