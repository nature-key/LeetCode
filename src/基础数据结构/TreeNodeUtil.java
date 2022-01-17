package 基础数据结构;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeUtil {


    public TreeNode root;

    public TreeNode add(Integer[] nums) {
        List<TreeNode> list = new ArrayList<>();
        for (Integer num : nums) {
            if(num==null){
                continue;
            }
            list.add(new TreeNode(num));
        }
        int size=list.size();

        for (int i = 0; i <=size/2-1 ; i++) {
            TreeNode left=list.get(2*i+1);
            TreeNode right=list.get(2*i+2);
            TreeNode treeNode = list.get(i);
            if(left!=null){
                treeNode.left=left;
            }
            if (right!=null) {
                treeNode.right=right;
            }
        }
        return list.get(0);
    }



    private void toPrint(TreeNode root){
        System.out.println(root.val);
    }


    public static void main(String[] args) {
        Integer[] nums={3,9,20,-1,-1,15,7};
        TreeNodeUtil util = new TreeNodeUtil();
        util.add(nums);
    }


}
