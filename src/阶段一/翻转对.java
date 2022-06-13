package 阶段一;

public class 翻转对 {

    /**
     * https://leetcode.cn/problems/reverse-pairs/solution/by-stormsunshine-9or8/
     * @param nums
     * @return
     */
        public int reversePairs(int[] nums) {

            return mergeSortAndCount(nums, 0, nums.length - 1);
        }

        public int mergeSortAndCount(int[] nums, int low, int high) {
            if (low >= high) {
                return 0;
            }
            int mid = (high + low) >> 1;
            int count = mergeSortAndCount(nums, low, mid) + mergeSortAndCount(nums, mid + 1, high);
            int i = low, j = mid + 1;
            while (i <= mid && j <= high) {
                if ((long) nums[i] > 2 * (long) nums[j]) {
                    count += mid - i + 1;
                    j++;
                } else {
                    i++;
                }
            }
            merge(nums,low,mid,high);
            return count;
        }


        public void merge(int[] nums, int low, int mid, int high) {
            int currentLength=high-low+1;
            int [] temp= new int[currentLength];
            int i=low,j=mid+1,k=0;
            while (i<=mid&&j<=high){
                if(nums[i]<=nums[j]){
                    temp[k++]=nums[i++];
                }else {
                    temp[k++]=nums[j++];
                }
            }
            while (i<=mid){
                temp[k++]=nums[i++];
            }
            while (j<=high){
                temp[k++]=nums[j++];
            }
            System.arraycopy(temp,0,nums,low,currentLength);
        }
}
