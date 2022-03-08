package 阶段一;

import 基础数据结构.TreeNode;

import java.util.HashMap;

public class 二叉树最大宽度 {

    private int ans;

    private HashMap<Integer, Integer> map;

    private int maxDepth(TreeNode root) {
        ans = 0;
        map = new HashMap<>();
        dfs(root, 0, 1);
        return ans;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }
        map.computeIfAbsent(depth, x -> pos);
        ans = Math.max(ans, pos - map.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }

}
