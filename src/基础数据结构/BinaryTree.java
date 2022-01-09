package 基础数据结构;

/**
 * 二叉搜索树
 */
public class BinaryTree {

    private TreeNode root = null;

    private   void insert(int key){
        if (root == null) {
            root = new TreeNode(key);
            return;
        }
        TreeNode curr = root;
        TreeNode parent = null;
        while (true) {
            if (curr == null) {
                if (parent.val > key) {
                    parent.left = new TreeNode(key);
                } else {
                    parent.right = new TreeNode(key);
                }
                return;
            }
            if (curr.val > key) {
                parent = curr;
                curr = curr.left;
            } else if (curr.val < key) {
                parent = curr;
                curr = curr.right;
            } else {
                System.out.println("重复的节点");
                break;
            }
        }
    }

    private void  inserts(int[] keys){
        for (int key : keys) {
            insert(key);
        }
    }


    private void  preOrder(){
        order(root);
    }
    private void  order(TreeNode head){
        if(head==null){
            return;
        }
        System.out.print(head.val+" ");
        order(head.left);
        order(head.right);
    }


    private void midOrder(){
        mOrder(root);
    }
    private  void mOrder(TreeNode head){
        if(head==null){
            return;
        }
        mOrder(head.left);
        System.out.print(head.val+" ");
        mOrder(head.right);
    }

    private void  afterOrder(){
        aOrder(root);
    }
    private void  aOrder(TreeNode head){
        if(head==null){
            return;
        }
        order(head.left);
        order(head.right);
        System.out.print(head.val+" ");
    }

    public static void main(String[] args) {
        int[] keys={3,20,7,9,15};

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.inserts(keys);

        binaryTree.midOrder();


    }

}
