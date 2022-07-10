package leetcode.leetCode2022_07;

import java.util.Arrays;

public class k994 {

    int colMax;
    int rowMax;


    public int orangesRotting(int[][] grid) {
        int ans = 0;
        colMax = grid.length;
        rowMax = grid[0].length;
        int[][] memo = new int[colMax][rowMax];

        for (int i = 0; i < colMax; i++)
            Arrays.fill(memo[i], Integer.MAX_VALUE);

        for (int i = 0; i < colMax; i++){
            for (int j = 0; j < rowMax; j++){
                if (grid[i][j] == 2) {
                    dfs(grid, memo,  1, i + 1, j);
                    dfs(grid, memo,  1, i - 1, j);
                    dfs(grid, memo,  1, i, j + 1);
                    dfs(grid, memo,  1, i, j - 1);
                }
            }
        }

        for (int i = 0; i < colMax; i++){
            for (int j = 0; j < rowMax; j++){
                if (grid[i][j] == 1) {
                    if (memo[i][j] == Integer.MAX_VALUE)
                        return -1;
                    ans = Math.max(ans, memo[i][j]);
                }
            }
        }

        return ans;
    }

    public void dfs(int[][] grid, int[][] memo, int step, int col, int row){
        //首先界限判断
        if (col == -1 || col == colMax || row == -1 || row == rowMax)
            return;
        //如果不是新鲜水果直接结束
        if (grid[col][row] == 2 || grid[col][row] == 0)
            return;

        //判断是否产生更新
        if (step <  memo[col][row]) {
            memo[col][row] = step;
            //四个方向扩散
            dfs(grid, memo, step + 1, col + 1, row);
            dfs(grid, memo, step + 1, col - 1, row);
            dfs(grid, memo, step + 1, col, row + 1);
            dfs(grid, memo, step + 1, col, row - 1);
        }
    }
}
