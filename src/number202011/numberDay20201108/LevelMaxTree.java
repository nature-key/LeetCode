package number202011.numberDay20201108;

import number202010.numberDay20201021.BinaryTree;
import number202010.numberDay20201021.TreeNode;

public class LevelMaxTree {


    private static int minLevel(TreeNode root) {

        if (root == null||root.getValue()==null) {
            return 0;
        }

        if (root.getLnode()==null||root.getLnode().getValue() == null) {
            return 1 + minLevel(root.getRnode());
        }
        if (root.getRnode()==null||root.getRnode().getValue() == null) {
            return 1 + minLevel(root.getLnode());
        }
        int lnode = minLevel(root.getLnode());
        int rnode = minLevel(root.getRnode());
        return 1 + Math.min(lnode,
                rnode);

    }


    private static int maxLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxLevel(root.getRnode()), maxLevel(root.getLnode()));

    }

    public static void main(String[] args) {
        Integer[] arrs = {3,9,20,null,null,15,7};
        BinaryTree root = new BinaryTree(arrs);
//        System.out.println(maxLevel(root.getRoot()));
        System.out.println(minLevel(root.getRoot()));
    }


}
