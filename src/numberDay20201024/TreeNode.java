package numberDay20201024;

public class TreeNode {

    private Integer data;

    private TreeNode leftNode;

    private TreeNode rightNode;

    public void add(Integer data) {
        if (data==null){
            return;
        }

        if (this.data > data) {
            if (this.leftNode == null) {
                this.leftNode = new TreeNode(data);
            } else {
                this.leftNode.add(data);
            }
        } else {
            if (this.rightNode == null) {
                this.rightNode = new TreeNode(data);
            } else {
                this.rightNode.add(data);
            }
        }
    }

    public void middleShow() {
        if (this.leftNode != null) {
            this.leftNode.middleShow();
        }
        System.out.print(this.data+" ");
        if (this.rightNode != null) {
            this.rightNode.middleShow();
        }
    }


    public TreeNode(int data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
