package number202010.numberDay20201024;

public class LowestCommonAncestor {


    private  TreeNode getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode treeNode=root;
        if (root.getData() > p.getData() && root.getData() > q.getData()) {
           treeNode= this.getLowestCommonAncestor(root.getLeftNode(), p, q);
        } else if (root.getData() < p.getData() && root.getData() < q.getData()) {
           treeNode= this.getLowestCommonAncestor(root.getRightNode(), p, q);
        }
        return treeNode;
    }

    private TreeNode getLowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode findNode = root;
        while (true) {
            if (findNode.getData() > p.getData() && findNode.getData() > q.getData()) {
                findNode = root.getLeftNode();
            } else if (findNode.getData() < p.getData() && findNode.getData() < q.getData()) {
                findNode = root.getRightNode();
            } else {
                break;
            }
        }
        return findNode;
    }


    public static void main(String[] args) {
        Integer [] datas={6,2,8,0,4,7,9,null,null,3,5};
        BinarySearchTree binarySearchTree =new BinarySearchTree();
        binarySearchTree.adds(datas);
        TreeNode p =new TreeNode(2);
        TreeNode q =new TreeNode(4);
        LowestCommonAncestor lowestCommonAncestor =new LowestCommonAncestor();
//        TreeNode lowestCommonAncestor1 = lowestCommonAncestor.getLowestCommonAncestor(binarySearchTree.getRoot(), p, q);
        TreeNode lowestCommonAncestor2 = lowestCommonAncestor.getLowestCommonAncestor2(binarySearchTree.getRoot(), p, q);

//        System.out.println(lowestCommonAncestor1.getData());
        System.out.println(lowestCommonAncestor2.getData());



    }
}
