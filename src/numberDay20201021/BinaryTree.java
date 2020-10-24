package numberDay20201021;

public class BinaryTree {

    TreeNode[] nodes;
    TreeNode root;
    int size;

    public BinaryTree() {
    }

    public BinaryTree(Integer[] arrays) {
        size = arrays.length;
        nodes = new TreeNode[size];
        //构建树节点
        for (int i = 0; i <arrays.length; i++) {
            nodes[i]=new TreeNode(arrays[i]);
        }
        for (int i = 0; i < (size - 2) / 2; i++) {
            nodes[i].setLnode(nodes[2 * i + 1]);
            nodes[i].setRnode(nodes[2 * i + 2]);
        }
        root = nodes[0];
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode[] getNodes() {
        return nodes;
    }

    public void setNodes(TreeNode[] nodes) {
        this.nodes = nodes;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
