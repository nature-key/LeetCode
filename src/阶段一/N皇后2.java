package 阶段一;

public class N皇后2 {

    public static int totalNQueens(int n) {
        return NQueens(n, 0, 0, 0, 0);
    }

    private static int NQueens(int n, int row, int col, int pai, int na) {

        if (row == n) {
            return 1;
        } else {

            int count = 0;
            int bits = ((~(col | pai | na)) & (1 << n) - 1);//获取到放置皇后的位置
            while (bits != 0) {
                int p = bits & -bits;//获取最后一个防防止皇后的位置
                count += NQueens(n, row+1, col | p, (pai | p) << 1, (na | p) >> 1);
                bits = bits & (bits - 1);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }


}
