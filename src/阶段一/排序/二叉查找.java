package 阶段一.排序;


public class 二叉查找 {

    /**
     * logn
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int l=0;
        int r=nums.length;
        while (l<=r){
            int mid = (r-l)/2;

            if(nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return -1;
    }
}
