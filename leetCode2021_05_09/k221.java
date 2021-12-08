package leetCode2021_05_09;

public class k221 {

    public static void main(String[] args) {
        char[][] arr = {{'1','1','1','1','0'},{'1','1','1','1','0'},
                {'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','1','1','1'}};
        System.out.println(new k221().maximalSquare(arr));
    }

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        int max = 0;

        for(int i = 1; i <= row; i++){
            for (int j = 1; j <= col; j++){
                if(matrix[i-1][j-1] == '1'){
                    int edgeLength = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]);
                    dp[i][j] = (int) Math.pow(Math.sqrt(edgeLength)+1,2);
                    max = Math.max(max,dp[i][j]);
                }//if
            }//for (int j
        }//for(int i

        return max;
    }
}
