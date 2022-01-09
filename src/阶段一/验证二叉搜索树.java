package 阶段一;

import 基础数据结构.TreeNode;

public class 验证二叉搜索树 {


    public boolean isValidBST(TreeNode root) {
        return isValiedBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    /**
     * 意思就是 当前节点在最小值和最大值之间
     *      左子树的根节点就是最大值，则更新最大值
     *      右子树的根节点就是最小值，则则更新最小值
     *      判断的就是当前不能超过max,或小于min
     * @param node
     * @param min
     * @param max
     * @return
     */
    private boolean isValiedBST(TreeNode node,int min,int max){
        if(node==null){
            return false;
        }
        //如果发现当前节点小于左子树的最大节点或者大于右子树最小节点 则不为二叉树
        if(node.val<=min||node.val>=max){
            return false;
        }
        //左子树的节点大于他的所有子节点，右子树的节点小于他的所有节点
        return isValiedBST(node.left,min,node.val)&&isValiedBST(node.right,node.val,max);




    }


}
