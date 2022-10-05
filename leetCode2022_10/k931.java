package leetcode.leetCode2022_10;

public class k931 {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 1; i < row; i++){
            matrix[i][0] += Math.min(matrix[i-1][0], matrix[i-1][1]);
            for (int j = 1; j < col - 1; j++)
                matrix[i][j] += Math.min(Math.min(matrix[i-1][j], matrix[i-1][j-1]), matrix[i-1][j+1]);
            matrix[i][col - 1] += Math.min(matrix[i-1][col - 1], matrix[i-1][col - 2]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++)
            ans = Math.min(ans, matrix[row - 1][i]);

        return ans;
    }
}
