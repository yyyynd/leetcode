package leetCode2021_05_09;

public class k63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[row-1][col-1] == 1)
            return 0;

        int[][] dp = new int[row+1][col+1];

        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= col; j++){
                if(i == 1 && j == 1){
                    dp[i][j] = 1;
                    continue;
                }
                //这个块为障碍物
                if(obstacleGrid[i-1][j-1] == 1)
                    dp[i][j] = -1;
                else {
                    if(dp[i-1][j] != -1)
                        dp[i][j] += dp[i-1][j];
                    if(dp[i][j-1] != -1)
                        dp[i][j] += dp[i][j-1];
                }
            }
        }

        return dp[row][col];
    }
}
