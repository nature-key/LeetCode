package 阶段热身.number202102.numberDay20210227;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private Node root;


    /**
     * 构建一棵树
     * @param nums -
     */
    public  void buildTree(int [] nums){
        List<Node> nodes = new ArrayList<>();
        for (int num : nums) {
            nodes.add(new Node(num));
        }
        int n =nodes.size();
        root=nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {



        }

    }

}
