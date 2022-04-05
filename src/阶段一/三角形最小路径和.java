package 阶段一;

import 阶段热身.number202102.INFO;

import java.util.*;

public class 三角形最小路径和 {

    /**
     * 字底向上
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public static synchronized int minimumTotal1(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
            }
        }

        return dp[0];
    }


    public static void main(String[] args) {

    }

    public int minimumTotal_min(List<List<Integer>> triangle) {
        int[] dp = new int [triangle.size()];
        for (int i = triangle.size()-1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
       return dp[0];
    }

    public int minimumTotal_1min(List<List<Integer>> triangle) {
        int size = triangle.size();
        int [][] dp = new int[size+1][size+1];
        for (int i = size-1; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }

        return dp[0][0];


    }


}
