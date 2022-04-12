package leetcode.leetCode2022_04;

public class k48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int n = 0; n < len/2; n++){
            for( int i = n; i < len - 1 - n; i++){
                int tmp = matrix[i][len - 1 - n];
                matrix[i][len - 1 - n] = matrix[n][i];
                matrix[n][i] = tmp;

                tmp = matrix[len - 1 - n][len - 1 - i];
                matrix[len - 1 - n][len - 1 - i] = matrix[n][i];
                matrix[n][i] = tmp;

                tmp = matrix[len - 1 - i][n];
                matrix[len - 1 - i][n] = matrix[n][i];
                matrix[n][i] = tmp;
            }
        }
    }
}
