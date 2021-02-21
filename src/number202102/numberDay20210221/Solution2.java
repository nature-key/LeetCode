package number202102.numberDay20210221;

import com.sun.source.doctree.StartElementTree;

import javax.print.DocFlavor;
import java.util.*;

public class Solution2 {

    public List<List<String>> solveNqueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> col = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        backtrack(solution,queens,n,0,col,pie,na);
        return solution;
    }

    public void backtrack(List<List<String>> solution,
                          int[] queens,
                          int n, int row, Set<Integer> col, Set<Integer> pie, Set<Integer> na) {
        if (row == n) {
            List<String> lsit = generateBorad(queens, n);
            solution.add(lsit);
        }else {
            for (int i = 0; i < n; i++) {
                if (col.contains(i)||pie.contains(row-i)||na.contains(row+i)) {
                    continue;
                }
                queens[row]=i;
                col.add(i);
                pie.add(row-i);
                na.add(row+i);
                backtrack(solution,queens,n,row+1,col,pie,na);
                queens[row]=-1;
                col.remove(i);
                pie.remove(row-i);
                na.remove(row+i);
            }
        }


    }

    public  List<String> generateBorad(int [] queens, int n){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queens[i]]='Q';
            result.add(new String(row));
        }
        return  result;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solveNqueens(4));
    }
}
