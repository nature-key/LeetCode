package 阶段一;

public class 打家劫舍2 {


    public int rob(int[] nums) {
        int length = nums.length;
        if(length==1){
            return nums[0];
        }else if(length==2){
            return Math.max(nums[0],nums[1]);
        }

        int v1 = maxValue(nums, 0, length - 2);
        int v2 = maxValue(nums, 1, length - 1);
        return Math.max(v1,v2);
    }


    public  static  int  maxValue(int [] nums ,int start,int end){
        int first=nums[start];
        int second=Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i <= end; i++) {
            int temp =second;
            second=Math.max(first+nums[i],second);
            first=second;
        }

        return second;
    }


}
