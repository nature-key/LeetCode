package numberDay20201024;

public class BinarySearchTree {

    private TreeNode root;


    public void adds(Integer[] datas) {
        for (Integer data : datas) {
            this.add(data);
        }
    }

    private void add(Integer data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            root.add(data);
        }
    }

    public void midlleShow() {
        root.middleShow();
    }


    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
