package 阶段热身.number202101.numberDay20210117;

public class Solution {

    private  void moveZero(int [] nums){
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                nums[j]=nums[i];
                if (i!=j) {
                    nums[i]=0;
                }
                j++;
            }
        }
    }


    private void moveZero1(int[] nums){
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                nums[j]=nums[i];
                if(i!=j){
                    nums[i]=0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution =new Solution();
        int [] nums={0,1,0,3,12};
        solution.moveZero(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
