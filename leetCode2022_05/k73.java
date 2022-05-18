package leetcode.leetCode2022_05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class k73 {
    public void setZeroes(int[][] matrix) {

        //为什么要区分首行首列，因为如果按照我们存储的方式
        //首行首列存放的地方是一样（即都会存放在00位置），无法做出区分
        boolean firstCol = false;
        boolean firstRow = false;

        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //开始置0（当然先从非0行0列开始）
        for (int i = 1; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                for (int j = 1; j < matrix[0].length; j++)
                    matrix[i][j] = 0;
            }
        }

        for (int i = 1; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                for (int j = 1; j < matrix.length; j++)
                    matrix[j][i] = 0;
            }
        }

        if (firstCol){
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }

        if (firstRow){
            Arrays.fill(matrix[0], 0);
        }
    }
}
