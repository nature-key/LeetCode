package 阶段一;

import java.util.ArrayList;
import java.util.List;

public class 子集 {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans,nums,new ArrayList<>(),0);
        return ans;

    }

    public void  dfs(List<List<Integer>> ans ,int[] nums ,
                     List<Integer> list,int index ){

        if (index==nums.length) {
            ans.add(list);
        }

        dfs(ans,nums,list,index+1);//不选数组元素

        list.add(nums[index]);
        dfs(ans,nums,list,index+1);//选择数组元素

        list.remove(list.size()-1);//状态还原
    }

}
