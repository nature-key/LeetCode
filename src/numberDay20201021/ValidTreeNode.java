package numberDay20201021;

public class ValidTreeNode {


    private static boolean isValidBST(TreeNode root) {
        return help(root, null, null);
    }

    /**
     *
     * @param root
     * @param min 树的节点的下界 比如，右子树的所有节点都大于根节点，根节点就是min
     * @param max 树的节点大小的上界，比如，左子树的所有节点都小于根节点，根节点就是max
     * @return
     */
    private static boolean help(TreeNode root, Integer min, Integer max) {
        if (root==null||root.value == null) {
            return true;
        }
        Integer val = root.value;
        if (min != null && val <= min) {
            return false;
        }
        if (max != null && val >= max) {
            return false;
        }
        if (!help(root.lnode, min, val)) {
            return false;
        }
        if (!help(root.rnode, val, max)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        Integer[] a= {3,1,5,null,null,2};
//        BinaryTree binaryTree = new BinaryTree(a);
//
//        boolean validBST = isValidBST(binaryTree.getRoot());
//        System.out.println(validBST);

        Integer[] a={2,3,5,6};

        BinaryTree binaryTree = new BinaryTree(a);

        System.out.println(binaryTree.nodes[1].getLnode());

    }
}
