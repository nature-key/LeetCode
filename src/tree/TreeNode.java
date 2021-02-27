package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private Node root;



    /**
     * 构建一棵树
     *
     * @param nums -
     * @return
     */
    public Node buildTreeNode(Integer [] nums) {
        List<Node> nodes = new ArrayList<>();
        for (Integer num : nums) {
            if(num==null){
                continue;
            }
            nodes.add(new Node(num));
        }
        int n = nodes.size();
        //父节点  n/2-1
        for (int i = 0; i <= n / 2 - 1; i++) {
            Node left = nodes.get(2 * i + 1);
            Node right = nodes.get(2 * i + 2);
            if (left != null) {
                nodes.get(i).setLeft(left);
            }
            if (right != null) {
                nodes.get(i).setRight(right);
            }
        }
        return nodes.get(0);
    }

    /**
     * 构建一棵二叉搜索树
     *
     * @param nums -
     * @return -
     */
    public Node createBinaryTree(Integer[] nums) {
        TreeNode node = new TreeNode();
        for (int num : nums) {
            buildBinaryTree(node.root, num);
        }
        return node.root;

    }

    private Node buildBinaryTree(Node root, int data) {

        if (root == null) {
            return root = new Node(data);
        } else {
            int val = root.getVal();
            if (val > data) {
                if (root.left != null) {
                    buildBinaryTree(root.getLeft(), data);
                } else {
                    root.setLeft(new Node(data));
                }
            } else {
                if (root.right != null) {
                    buildBinaryTree(root.right, data);
                } else {
                    root.setRight(new Node(data));
                }
            }
        }
        return root;
    }

}
