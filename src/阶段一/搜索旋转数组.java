package 阶段一;

public class 搜索旋转数组 {


    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if (nums[l] == target) {
                return l;
            }

            int mid = (l + r) / 2;

            if (nums[mid] > nums[l]) {
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] < nums[l]) {
                if (nums[mid] >= target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                l++;
            }
        }
        return -1;
    }



    public int search1(int[] nums, int target) {
        int l =0;
        int r=nums.length-1;

        while (l<=r){
            int mid =l+(r-l)/2;

            if(nums[mid]==target){
                return mid;
            }
            if(nums[l]<=nums[mid]){
                 if(target<=nums[mid]&&target>nums[l]){
                     r=mid-1;
                 }else {
                     l=mid+1;
                 }
            }else {
                if(nums[mid]<target&&target<=nums[r]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
        }

        return -1;

    }


}
