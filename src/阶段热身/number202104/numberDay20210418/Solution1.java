package 阶段热身.number202104.numberDay20210418;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {


    public  int  queue(int n){
        Set<Integer> col=new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        return  backtrack(n,0,col,pie,na);

    }


    public int backtrack(int n, int row, Set<Integer> col,
                         Set<Integer> pie, Set<Integer> na) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {

                if (col.contains(i)) {
                    continue;
                }
                int p = row - i;
                if (pie.contains(i)) {
                    continue;
                }
                int a = row + i;
                if (na.contains(i)) {
                    continue;
                }
                col.add(i);
                pie.add(p);
                na.add(a);
                count += backtrack(n, row + 1, col, pie, na);
                col.remove(i);
                pie.remove(p);
                na.remove(a);
            }
            return count;
        }

    }


}
