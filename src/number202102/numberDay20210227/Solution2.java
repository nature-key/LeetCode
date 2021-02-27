package number202102.numberDay20210227;

public class Solution2 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static  char[][] g;
    public static int numIslands(char[][] grid) {
        int result=0;
        g=grid;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if(g[i][j]=='0'){
                    continue;
                }
                result+=sink(i,j);
            }
        }
        return result;
    }


    public static int sink(int i, int j) {

        if (g[i][j] == '0') {
            return 0;
        }
        g[i][j] = '0';

        for (int k = 0; k < dx.length; ++k) {
            int x=i+dx[k];
            int y=j+dy[k];
            if(x>=0&&x<g.length&&y>=0&&y<g[i].length){
                if(g[x][y]=='0'){
                    continue;
                }
                sink(x,y);
            }
        }
        return 1;
    }


    public static void main(String[] args) {
        char[][] g={
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(g));
    }

}
