package 阶段热身.number202012.numberDay20201222;

import java.util.List;

public class Solution {

    private static int min(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n + 1][n + 1];//这里计算最后一行的时候
        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j <=i ; j++) {
                f[i][j]=Math.min(f[i+1][j],f[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return f[0][0];
    }

    public static void main(String[] args) {
//        List<List<Integer>> list=List.of(
//                List.of(2),
//                List.of(3,4),
//                List.of(6,5,7),
//                List.of(4,1,8,3)
//        );

//        System.out.println(min(list));
    }
}
