package 阶段热身.number202101.numberDay20210102;

public class Solution {

    private static void dfs(char[][] gird, int row, int col) {
        int nr = gird.length;
        int nc = gird[0].length;
        if ((row < 0 || col < 0 || row >= nr | col >= nc || gird[row][col] == '0')) {
            return;
        }
        gird[row][col] = '0';
        dfs(gird, row - 1, col);
        dfs(gird, row + 1, col);
        dfs(gird, row, col - 1);
        dfs(gird, row, col + 1);
    }

    private static int num_isLands(char[][] gird) {
        if (gird == null || gird.length == 0) {
            return 0;
        }
        int numberCount = 0;
        int nr = gird.length;
        int nc = gird[0].length;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (gird[r][c] == '1') {
                    numberCount++;
                    dfs(gird, r, c);
                }
            }
        }
        return numberCount;
    }

    public static void main(String[] args) {
        char[][] gird = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(num_isLands(gird));

    }


}
