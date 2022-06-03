package 阶段一;

public class 螺旋矩阵2 {

    public int[][] generateMatrix(int n) {
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = n - 1;
        int nums = 1;
        int tar = n * n;
        int[][] mat = new int[n][n];
        while (nums <= tar) {
            for (int i = l; i <= r; i++) {
                mat[t][i] = nums++;
            }
            t++;

            for (int i = t; i <= b; i++) {
                mat[i][r] = nums++;
            }
            r--;

            for (int i = r; i >= l; i--) {
                mat[b][i] = nums++;
            }
            b--;

            for (int i = b; i >= t; i--) {
                mat[i][l] = nums++;
            }
            l++;
        }
        return mat;
    }

}
