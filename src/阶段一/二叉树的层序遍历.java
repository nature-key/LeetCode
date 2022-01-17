package 阶段一;

import 基础数据结构.ListNode;
import 基础数据结构.TreeNode;
import 基础数据结构.TreeNodeUtil;

import java.util.*;

public class 二叉树的层序遍历 {

    /**
     * BFS
     *
     * @param root -
     * @return -
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            res.add(currLevel);
        }

        return res;
    }

    public static void main(String[] args) {
        Integer[] nums={3,9,20,null,null,15,7};
        TreeNodeUtil util = new TreeNodeUtil();
        TreeNode root = util.add(nums);

        List<List<Integer>> lists = levelOrder(root);

        lists.forEach(it->{
            System.out.println(Arrays.asList(it));
        });


    }
}
