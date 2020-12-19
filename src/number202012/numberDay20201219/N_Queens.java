package number202012.numberDay20201219;



public class N_Queens {

    private static int solve(int n, int row, int col, int pai, int na) {

        if (row == n) {
            return 1;
        } else {
            int count = 0;
            int bit = (~(col | pai | na)) & ((1 << n) - 1);
            while (bit != 0) {
                int p = bit & (-bit);
                count += solve(n, row + 1, col | p, (pai | p) << 1, (na | p) >> 1);
                bit = bit & (bit - 1);
            }
            return count;
        }
    }

    public static int totalQueens(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    public static void main(String[] args) {
        int i = totalQueens(4);
        System.out.println(i);
    }


}
