package leetcode.leetCode2022_06;

public class k200 {
    public static void main(String[] args) {
        String t = "test";
        System.out.println(t.substring(0,1));
    }
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1' ){
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }

        return ans;
    }

    public void dfs(char[][] grid, int row, int col){
        if (row == grid.length || col == grid[0].length ||
                row == -1 || col == -1 || grid[row][col] != '1')
            return;
        grid[row][col] = '2';
        dfs(grid,row + 1, col);
        dfs(grid,row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
