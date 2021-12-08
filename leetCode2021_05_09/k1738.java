package leetCode2021_05_09;

import java.util.Arrays;

public class k1738 {
    int [] s;
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, count = 0;
        int[][] values = new int[m + 1][n + 1];
        int[] res = new int[m * n];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                values[i][j] = (values[i][j - 1] ^ values[i - 1][j] ^
                        values[i - 1][j - 1] ^ matrix[i - 1][j -  1]);
                res[count++] = values[i][j];
            }
        }

        // 升序数组
        Arrays.sort(res);

        return res[res.length - k];
    }
}
