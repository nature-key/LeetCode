package number202102.numberDay20210227;

import number202102.INFO;
import tree.Node;
import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {


    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.getVal());
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            result.add(level);
        }

        return result;
    }

    public static List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, 0);
        return result;

    }

    private static void dfs(List<List<Integer>> result, Node node, int level) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.getVal());
        if (node.getLeft() != null) {
            dfs(result, node.getLeft(), level + 1);
        }
        if (node.getRight() != null) {
            dfs(result, node.getRight(), level + 1);
        }

    }


    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = new TreeNode();
        Node node = root.buildTreeNode(nums);

        System.out.println(levelOrder(node));


        System.out.println(levelOrder1(node));

    }


//    ÷


}
