package leetcode.leetCode2022_09;

public class k695 {

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    ans = Math.max(ans, dfs(grid, i, j));
                }//if
            }//for
        }//for

        return ans;
    }

    public int dfs(int[][] grid, int row, int col){
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length)
            return 0;

        if (grid[row][col] == 0)
            return 0;

        int subRes = 1;
        grid[row][col] = 0;
        subRes += dfs(grid,row - 1, col);
        subRes += dfs(grid, row + 1, col);
        subRes += dfs(grid, row, col - 1);
        subRes += dfs(grid, row, col + 1);

        return subRes;
    }
}
