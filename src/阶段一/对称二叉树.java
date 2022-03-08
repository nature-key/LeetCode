package 阶段一;

import 基础数据结构.TreeNode;

public class 对称二叉树 {

    public boolean isSymmetric(TreeNode root) {

        return isTrue(root,root);
    }

    private boolean isTrue(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        return t1.val==t2.val&&isTrue(t1.left,t2.right)
                &&isTrue(t1.right,t2.left);


    }

}
