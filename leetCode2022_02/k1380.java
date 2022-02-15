package leetcode.leetCode2022_02;

import java.util.LinkedList;
import java.util.List;

public class k1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        List<Integer> ans = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++)
                if( matrix[i][j] < matrix[i][row[i]])
                    row[i] = j;
        }

        for (int i = 0; i < matrix[0].length; i++){
            for (int j = 0; j < matrix.length; j++)
                if( matrix[j][i] > matrix[col[i]][i])
                    col[i] = j;
        }

        for (int i = 0; i < matrix.length; i++){
            if( i == col[row[i]])
                ans.add(matrix[i][row[i]]);
        }

        return ans;
    }
}
