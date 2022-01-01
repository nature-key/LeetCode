package 阶段热身.number202103.numberDay20210328;

public class Test {


    private static int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    unionFind.unionset(i, j);
                }

            }
        }
        return unionFind.getCount();

    }


    public static void main(String[] args) {
        int[][] m={
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        System.out.println(findCircleNum(m));
    }
}
