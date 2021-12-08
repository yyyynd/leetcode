package leetCode2021_05_09;

public class k64 {

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(new k64().minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(col == 0)
            return 0;
        for (int i = 1; i < row; i++ ){
            grid[i][0] += grid[i-1][0];
        }
        for (int j = 1; j < col; j++) {
            grid[0][j] += grid[0][j-1];
        }
        for (int i = 1; i < row; i++ ){
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[row-1][col-1];
//        int[][] dp = new int[row+1][col+1];
//
//        for (int i = 0; i <=row; i++)
//            dp[i][0] = Integer.MAX_VALUE;
//
//        for (int i = 0; i <=col; i++)
//            dp[0][i] = Integer.MAX_VALUE;
//
//        for(int i = 1; i <= row; i++){
//            for (int j = 1; j <= col; j++){
//                if(i == 1 && j == 1){
//                    dp[i][j] = grid[i-1][j-1];
//                    continue;
//                }
//                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
//            }
//        }
//        return dp[row][col];
    }
}
