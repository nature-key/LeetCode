package number202101.numberDay20210110;

public class Solution {


    public static int minNumberTotal(int[][] triangle) {

        if (triangle.length == 0 || triangle[0].length == 0) {
            return 0;
        }
        return minNumberDFS(triangle, 0, 0);
    }
    private static Integer[][] min=new Integer[100][100];
    public static int minNumberDFS(int[][] triangle, int i, int j) {
        if (triangle.length - 1 == i) {
            return triangle[i][j];
        }
        if (min!=null&&null!=min[i][j]) {
            return min[i][j];
        }

        int left = minNumberDFS(triangle, i + 1, j);
        int right = minNumberDFS(triangle, i + 1, j + 1);
        return min[i][j]= triangle[i][j] + Math.min(left, right);
    }


    private static int dpMin(int[][] triangle) {

        int n = triangle.length;
        int [] dp = new int[n+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle[i][j];
            }
        }
        return dp[0];
    }


    private static int dpMin2(int[][] triangle){
        int n = triangle.length;
        int[][] dp = new int[n+1][n+1];

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <=i ; j++) {
                dp[i][j]=triangle[i][j]+Math.min(dp[i+1][j+1],dp[i+1][j]);

            }
        }

       return dp[0][0];


    }




    public static void main(String[] args) {
        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
//        System.out.println(dpMin(triangle));
        System.out.println(minNumberTotal(triangle));
//        System.out.println(dpMin2(triangle));
    }


}
