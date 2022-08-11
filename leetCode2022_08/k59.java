package leetcode.leetCode2022_08;

public class k59 {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int c = 1;
        for (int k = 0; k < n / 2 + n % 2 ; k++){
            int row = k, col = k;
            for (int i = 0; i < n - k * 2; i++){
                ans[row][col] = c++;
                col++;
            }
            col--;
            row++;
            for (int i = 0; i < n - k * 2 - 1; i++){
                ans[row][col] = c++;
                row++;
            }
            row--;
            col--;
            for (int i = 0; i < n - k * 2 - 1; i++){
                ans[row][col] = c++;
                col--;
            }
            col++;
            row--;
            for (int i = 0; i < n - k * 2 - 1; i++){
                ans[row][col] = c++;
                row--;
            }
        }

        return ans;
    }
}
