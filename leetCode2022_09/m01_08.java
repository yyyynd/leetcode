package leetcode.leetCode2022_09;

import java.util.Arrays;

public class m01_08 {
    public void setZeroes(int[][] matrix) {
        boolean rowFlag = false;
        boolean colFlag = false;

        for (int i = 0; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                rowFlag = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }//for
        }//for
        for (int i = 1; i < matrix.length; i++){
            if (matrix[i][0] != 0)
                continue;
            for (int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = 0;
            }
        }

        for (int i = 1; i < matrix[0].length; i++){
            if (matrix[0][i] != 0)
                continue;
            for (int j = 0; j < matrix.length; j++){
                matrix[j][i] = 0;
            }
        }

        if (rowFlag)
            Arrays.fill(matrix[0], 0);
        if (colFlag){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
