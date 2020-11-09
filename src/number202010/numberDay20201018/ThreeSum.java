package number202010.numberDay20201018;

import java.util.*;

public class ThreeSum {


    private static List<List<Integer>> getThreeSum(int[] nums){

        List<List<Integer>> result= new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = i+j+1; k < nums.length; k++) {
                    if (nums[i]+nums[j]+nums[k]==0) {

                        result.add(List.of(nums[i],nums[j],nums[k]));
                    }

                }
            }
        }
        List<List<Integer>> lists =new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            for (int j = i+1; j < result.size(); j++) {
                Object[] objects1 = result.get(i).toArray();
                Object[] objects2 = result.get(j).toArray();
                Arrays.sort(objects1);
                Arrays.sort(objects2);
                if (!Arrays.equals(objects1,objects2) ){
                    lists.add(result.get(i));
                }

            }

        }

       return lists;
    }

    private  static  List<List<Integer>> threeSum(int[] nums){

        Arrays.sort(nums);
        List<List<Integer>> list =new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]) {
                continue;
            }
            int L=i+1;
            int R=nums.length-1;

            while (L<R){
                int s = nums[i] + nums[L] + nums[R];
                if(s>0){
                    R--;
                }else if(s<0){
                    L++;
                }else {
                    list.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R&&nums[L]==nums[L+1]){
                        L++;
                    }
                    while (L<R&&nums[R]==nums[R-1]){
                        R--;
                    }
                    L++;
                    R--;
                }
            }


        }

        return list;
    }

    public static void main(String[] args) {
      int[]  nums = {-1, 0, 1, 2, -1, -4};
//        Arrays.sort(nums);
        System.out.println(Arrays.toString(getThreeSum(nums).toArray()));

        List<List<Integer>> lists = threeSum(nums);

        System.out.println(Arrays.toString(lists.toArray()));

    }


}
