package number202012.numberDay20201219;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {

    private static int solve(List<List<String>> solutions,int[] queens,int n, int row, int col, int pai, int na) {

        if (row == n) {
            solutions.add(gen(queens,n));
            return 1;
        } else {
            int count = 0;
            int bit = (~(col | pai | na)) & ((1 << n) - 1);
            while (bit != 0) {
                int p = bit & (-bit);
                queens[row]=Integer.bitCount(p-1);
                count += solve(solutions,queens,n, row + 1, col | p, (pai | p) << 1, (na | p) >> 1);
                bit = bit & (bit - 1);
                queens[row]=-1;
            }
            return count;
        }
    }

    private static List<String>  gen(int[] queens, int n) {
        List<String> board =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row =new char[n];
            Arrays.fill(row,'.');
            row[queens[i]]='Q';
            board.add(new String(row));
        }
        return board;
    }

    public static int totalQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> solutuins = new ArrayList<>();
         int count =solve(solutuins,queens,n, 0, 0, 0, 0);
       solutuins.forEach(it->{

           for (String s : it) {
               System.out.println(s.toCharArray());
           }

           System.out.println();
       });

        return  count;
    }

    public static void main(String[] args) {
        int i = totalQueens(4);
        System.out.println(i);
    }


}
