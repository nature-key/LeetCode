package 阶段热身.number202011.numberDay20201104;

import 阶段热身.number202010.numberDay20201021.BinaryTree;
import 阶段热身.number202010.numberDay20201021.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {


    private static List<List<Integer>> getLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int nodeNum = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < nodeNum; i++) {
                TreeNode node = queue.poll();
                if (node.getValue() != null) {
                    level.add(node.getValue());
                }
                if (node.getLnode() != null) {
                    queue.add(node.getLnode());
                }
                if (node.getRnode() != null) {
                    queue.add(node.getRnode());
                }
            }
            result.add(level);
        }


        return result;

    }

    public static void main(String[] args) {
        Integer[] a = {3, 9, 20, null, null, 15, 7};

        BinaryTree binaryTree = new BinaryTree(a);
        for (List<Integer> integers : getLevelOrder(binaryTree.getRoot())) {

            System.out.println(integers.toString());
        }
    }

}
