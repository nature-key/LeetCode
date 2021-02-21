package number202102.numberDay20210206;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {


    public Integer val;

    public TreeNode left;

    public TreeNode right;

    private TreeNode root;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
    }

    private TreeNode adds(List<Integer> list) {
        TreeNode temp = root;
        for (Integer integer : list) {
            if (integer == null) {
                continue;
            }
            TreeNode node = new TreeNode(integer);
            TreeNode treeNode = add(node, temp);
            temp = treeNode;
        }
        return temp;

    }

    private TreeNode add(TreeNode node, TreeNode root) {
        if (node == null && node.val == null) {
            return null;
        }
        if (root != null && root.val != null) {
            int val = root.val;
            if (val > node.val) {
                if (root.left != null) {
                    add(node, root.left);
                } else {
                    root.left = node;
                }
            } else {
                if (root.right != null) {
                    add(node, root.right);
                } else {
                    root.right = node;
                }
            }
        } else {
            root = node;
        }
        return root;
    }

    private static List<Integer> middleOrder(TreeNode root, List<Integer> result) {
        if (root != null) {
            middleOrder(root.left, result);
            result.add(root.val);
            middleOrder(root.right, result);
        }
        return result;
    }

    private static List<Integer> minddOrder2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, null, 2, 3};
        List<Integer> list = new ArrayList<>();
        for (Integer num : nums) {
            list.add(num);
        }
        TreeNode noe = new TreeNode();
        TreeNode adds = noe.adds(list);
//        List list1 = new ArrayList();
//        List list2 = middleOrder(adds, list1);
        List<Integer> list3 = minddOrder2(adds);
        list3.forEach(it -> {
            if (it != null) {
                System.out.println(it);
            }
        });
//        for (Object o : list2) {
//            System.out.println(o);
//        }

    }


}
