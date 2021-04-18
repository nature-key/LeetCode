package number202104.numberDay20210418;

public class Solution2 {
    /**
     * (1 << n) - 1 这个语句实际上生成了n个1.这里的1表示可以放置皇后（其实就是初始化了n个1，
     * 在不考虑皇后之间可以相互攻击的情况下，n个位置都可以放皇后）；
     * ~(col | ld | rd)这里的三个变量分别代表了列以及两个斜线的放置情况。
     * 这里的1表示的是不能放置皇后(就是相应的列或斜线上已经放置过皇后了)，
     * 这与之前 (1 << n) - 1生成的n个1是不同含义的。
     * @param n
     * @return
     */
    public int Nqueens(int n){
        return solve(n,0,0,0,0);
    }

    public int solve(int n, int row, int col, int pie, int na) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            int avaliablePostion = (~(col | pie | na)) & ((1 << n) - 1);
            while (avaliablePostion != 0) {
                int postion = avaliablePostion & (-avaliablePostion);//获取最低1位
                avaliablePostion = avaliablePostion & (avaliablePostion - 1);
                count+=solve(n, row + 1, col | postion, (pie | postion) << 1, (na | postion) >> 1);
            }
            return count;
        }
    }


}
