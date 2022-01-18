package 阶段一;

import 基础数据结构.TreeNode;

public class 二叉树的最大深度 {

    /**
     * 递归
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        return 1+Math.max(maxDepth(root.right),maxDepth(root.left));
    }

    /**
     * 1.root是叶子节点
     * 2.没有左节点或者右节点
     * 3.既有左节点有有右节点
     * @param root
     * @return
     */
    public int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left==0||right==0)?left+right+1:Math.min(left,right)+1;



    }

}
