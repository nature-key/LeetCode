package 阶段一;

public class 移动零 {



    public int[] getNums(int[] nums){
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[j]=nums[i];
                if(i!=j){
                    nums[i]=0;
                }
                j++;
            }
        }
        return nums;
    }
}
