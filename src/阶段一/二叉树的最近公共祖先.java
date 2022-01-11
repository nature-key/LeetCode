package 阶段一;

import 基础数据结构.BinaryTree;
import 基础数据结构.ListNodeUtil;
import 基础数据结构.TreeNode;

public class 二叉树的最近公共祖先 {


    /**
     * 比较根节点和p和q,如果有任意一个相等，找到返回根节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //比较根节点和p和q,如果有任意一个相等，找到返回根节点
        if (root == null || root.val == q.val || root.val == p.val) {
            return root;
        }
        //递归先在左子树中找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //递归在右子树中找
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左子树没有，则返回右子树，否则，右子树没有，则返回左子树，都有则返回根节点
        return left == null ? right : right == null ? left : root;
    }

    /**
     * 二叉搜索树
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorBin(TreeNode root, TreeNode p, TreeNode q) {

        if (q.val < root.val && root.val > p.val) { //在左子树中
            return lowestCommonAncestorBin(root.left, p, q);
        } else if (q.val > root.val && root.val < p.val) {//在右子树中
            return lowestCommonAncestorBin(root.right, p, q);
        }
        return root;//即分叉了，root就是根节点
    }

    public static void main(String[] args) {
        int[] nums={3,5,1};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.inserts(nums);
        binaryTree.midOrder();

        System.out.println(lowestCommonAncestor(binaryTree.root, new TreeNode(5), new TreeNode(7)).val);
    }


}
