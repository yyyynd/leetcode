package leetCode2021_09;

/**
 * 这题确实没有什么方法对判断方式进行优化，但可以通过对存储方式进行优化
 * 一开始容易想到哈希表，但注意一般能用哈希的都可以用数组（自己手动加判断）
 * 但最方便的是用位运算来实现检查
 *
 * 注意位运算存储信息的方式，节省空间同时判断也快，对于这种数据要求保持唯一的
 * 十分适合
 */

public class k36 {
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        int[] col = new int[length], row = new int[length], matrix = new int[length];
        //加数据
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                if(board[i][j] == '.')
                    continue;
                int n = board[i][j] - '1';
                int matrixIndex = i/3*3 + j/3;
                if((row[i]>>n  & 1 ) != 1 && (col[j] >> n & 1)  != 1 &&
                        (matrix[matrixIndex] >> n & 1) != 1) {
                    row[i] = row[i ] | (1 << n);
                    col[j] = col[j] | (1 << n);
                    matrix[matrixIndex] =  matrix[matrixIndex] | (1 << n);
                }else
                    return false;
            }//for
        }//for

        return true;
    }//isValidSudoku
}
