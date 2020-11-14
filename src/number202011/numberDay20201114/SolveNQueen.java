package number202011.numberDay20201114;

import javax.print.DocFlavor;
import java.util.*;

public class SolveNQueen {


    public static void main(String[] args) {
        int n=4;
        List<List<String>> list = new ArrayList<>();
        int [] queen= new int[n];
        Arrays.fill(queen,-1);
        Set<Integer> col=new HashSet<>();
        Set<Integer> pei = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        backList(list,queen,n,0,col,pei,na);
//        System.out.println(list.toString());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

    }


    public static void backList(List<List<String>> list, int[] queen, int n, int row, Set col, Set pie, Set na) {

        if (row == n) {
            //把queen 里面记录就是一种解法，遍历出结果
            list.add(board(queen, n));
        } else {
            for (int i = 0; i < n; i++) {
                if (col.contains(i)) {
                    continue;
                }
                int pie1 = row + i;
                if (pie.contains(pie1)) {
                    continue;
                }
                int na1 = row - i;
                if (na.contains(na1)) {
                    continue;
                }
                //这里就代表这个列适合放皇后
                queen[row] = i;
                col.add(i);
                pie.add(pie1);
                na.add(na1);
                backList(list, queen, n, row + 1, col, pie, na);
                queen[row] = -1;
                col.remove(i);
                pie.remove(pie1);
                na.remove(na1);
            }
        }


    }


    private static List<String> board(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row)+"\n");
        }
        return board;
    }


}
