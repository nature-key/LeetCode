package 阶段一;

public class 岛屿数量 {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i < 0 ||
                i >= grid.length || j >= grid[0].length
                || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }




    public int numIslands1(char[][] grid) {
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private  int [] dx = {-1,1,0,0};
    private  int [] dy = {0,0,-1,1};
    public  void dfs1(char[][]gird,int i,int j){
        if(i<0||j<0||i>=gird.length||j>=gird[0].length||gird[i][j]=='0'){
            return;
        }
        gird[i][j]='0';
        for (int k = 0; k < dx.length; k++) {
            int x=i+dx[k];
            int y=j+dy[k];
            if(gird[x][y]=='1'){
                dfs1(gird,x,y);
            }


        }


    }

}
