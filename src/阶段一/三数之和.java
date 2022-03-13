package 阶段一;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {

    private static  List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for (int k = 0; k < nums.length-2; k++) {
            if(nums[k]>0){
                break;
            }
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            int i=k+1;
            int j=nums.length-1;
            while (i<j){
                if(nums[k]+nums[i]+nums[j]>0){
                    --j;
                }else if(nums[k]+nums[i]+nums[j]<0){
                    ++i;
                }else if(nums[k]+nums[i]+nums[j]==0){
                    result.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j])));
                    ++i;
                    --j;
                }
            }
        }
        return result;
    }


    private static  List<List<Integer>> threeSum1(int[]nums){
        Arrays.sort(nums);

        List<List<Integer>> result=new ArrayList<>();
        for (int k = 0; k < nums.length-2; k++) {
            if (nums[k]>0) {
                break;
            }
            if (k>0&&nums[k]==nums[k-1]) {
                continue;
            }
            int i=k+1;
            int j=nums.length-1;
            while (i<j){
                int sum=nums[k]+nums[i]+nums[j];
                if(sum>0){
                    while (i<j&&nums[j]==nums[--j]);
                }else if(sum<0){
                    while (i<j&&nums[i]==nums[++i]);
                }else{
                    result.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    while (i<j&&nums[i]==nums[++i]);
                    while (i<j&&nums[j]==nums[--j]);
                }
            }
        }
            return result;
    }



    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
        System.out.println(threeSum1(nums));

    }


    public List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> result = new ArrayList<>();



        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) {
                break;;
            }
            if(nums[i]==nums[i-1]){
                continue;
            }

            int L=i+1;
            int R=nums.length-1;
            int sum = nums[i]+nums[L]+nums[R];
            if(sum==0){
                result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                while (L<R&&nums[L]==nums[L+1]) L++;
                while (L<R&&nums[R]==nums[R-1]) R--;
                L++;
                R--;
            }else if(sum<0){
                L++;
            }else if(sum>0){
                R--;
            }
        }

       return result;
    }


}
