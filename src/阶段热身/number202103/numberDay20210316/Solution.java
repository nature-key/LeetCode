package 阶段热身.number202103.numberDay20210316;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    private static int findNum(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    private static int minTotal(int[][] triangle) {
        for (int i = triangle.length - 2; i >= 0; i--) {
            int[] list = triangle[i];
            for (int j = 0; j < list.length; j++) {
                triangle[i][j] = triangle[i][j]
                        + Math.min(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0];
    }

    private static int maxTotal(List<List<Integer>> triangle) {

        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[][] triangle = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };

       List<List<Integer>> lists =new ArrayList<>();


        System.out.println(minTotal(triangle));
    }


}
