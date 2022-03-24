package 阶段一;

import 基础数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树中序遍历 {


    public List<Integer> midSearh(TreeNode root){
        List<Integer> result = new ArrayList<>();
        dfs(result,root);
        return result;

    }

    public  void  dfs(List<Integer> result,TreeNode root){
        if(root==null){
            return;
        }
        dfs(result,root.left);
        result.add(root.val);
        dfs(result,root.right);



    }






}
