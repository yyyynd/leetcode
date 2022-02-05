package leetcode.leetCode2022_02;

/**
 * 虽然本题无法记忆化来剪枝，但一开始减少计算的思路没有问题
 * 如果一个点其相邻块有两个以上是有值的，那么其必不可能成为
 * 最优路径的起点（开始我想的是起点只有一个非零相邻点，但如果是个正方形就有问题了）
 */
public class k1219 {
    //两个边界
    int x_limit;
    int y_limit;
    //四个方向
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        x_limit = grid.length;
        y_limit = grid[0].length;

        for (int x = 0; x < x_limit; x++){
            for (int y = 0; y < y_limit; y++){
                int count = 0;
                if(grid[x][y] == 0)
                    continue;
                for (int[] dir : dirs){
                    if(x + dir[0] >= 0 && x + dir[0] < x_limit && y + dir[1] >= 0 && y + dir[1] < y_limit){
                        if(grid[x + dir[0]][y + dir[1]] != 0)
                            count++;
                    }
                }
                if(count <= 2)
                    ans = Math.max(ans, dfs(grid, 0, x, y));
            }
        }

        return ans;
    }

    public int dfs(int[][] grid, int sum, int x, int y){
        //首先判断是否越界or此处是否为0
        if( x < 0 || y < 0 || x == x_limit || y == y_limit || grid[x][y] == 0)
            return sum;

        int tmp = grid[x][y];
        int res = 0;
        grid[x][y] = 0;

        for (int[] dir : dirs){
            res = Math.max(res, dfs(grid, sum + tmp, x + dir[0], y + dir[1]));
        }

        grid[x][y] = tmp;
        return res;
    }
}
