package 阶段一;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {


        int m = matrix.length;
        int n = matrix[0].length;
        int count = (Math.min(m, n) + 1) / 2;
        int i = 0;
        List<Integer> list= new ArrayList<>();
        while (i < count) {

            for (int j = i; j <n-i; j++) {
                list.add(matrix[i][j]);
            }

            for (int j = i+1; j < m-i; j++) {
                list.add(matrix[n-1-i][j]);
            }

            for (int j = (n-1)-(i+1); j <i&(m-1-i!=i) ; j--) {
                list.add(matrix[m-1-i][j]);
            }

            for (int j = (m-1)-(i+1); j <i&&(n-1-i!=i) ; j--) {
                list.add(matrix[j][i]);
            }
            i++;
        }

        return list;

    }

}
