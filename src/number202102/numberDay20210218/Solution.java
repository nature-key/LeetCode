package number202102.numberDay20210218;

import number202102.numberDay20210206.TreeNode;

import java.util.List;

public class Solution {


    public int climbStair(int l, int n) {
        if (l > n) {
            return 0;
        }

        if (l == n) {
            return 1;
        }
        return climbStair(l + 1, n) + climbStair(l + 2, n);
    }

    public int climbStaits(int n) {
        return climbStair(0, n);
    }

    public int climbStairs1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }


    public List<String> _generates(int n) {
        _generate(0, 0, n, "");
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution._generates(3);
    }

    public void _generate(int left, int right, int n, String s) {
        //终止条件
        if (left == n && right == n) {
            System.out.println(s);
            return;
        }
        //处理
        //x向下走
        if (left < n) {
            _generate(left + 1, right, n, s + "(");
        }
        if (left > right) {
            _generate(left, right + 1, n, s + ")");
        }
    }

    public boolean help(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;// TODO: 2021/2/18
        }
        Integer val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!help(node.right, val, upper)) {
            return false;
        }

        if (!help(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }


}
