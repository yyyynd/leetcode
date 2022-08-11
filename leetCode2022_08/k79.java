package leetcode.leetCode2022_08;

import java.util.Arrays;

public class k79 {

    public static void main(String[] args) {
        System.out.println(new k79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB" ));
    }

    int len;
    public boolean exist(char[][] board, String word) {
        this.len = word.length();
        char[] t1 = word.toCharArray();
        char[] t2 = new char[len];
        char head = t1[0];
        char tail = t1[len - 1];
        for (int i = 0 ; i < len; i++)
            t2[i] = t1[len - 1 - i];


        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == head && dfs(board, t1, i, j, 0))
                    return true;
                else if (board[i][j] == tail && dfs(board, t2, i, j, 0))
                    return true;
            }
        }

        return false;

    }

    public boolean dfs(char[][] board, char[] target, int row, int col, int index){
        if (index == len)
            return true;

        //判断所有不符合条件的情况
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1)
            return false;
        else if (board[row][col] != target[index])
            return false;

        board[row][col] = ' ';
        boolean res =  dfs(board, target, row + 1, col, index + 1) ||
                dfs(board, target, row - 1, col, index + 1) ||
                dfs(board, target, row, col + 1, index + 1) ||
                dfs(board, target, row, col - 1, index + 1);
        board[row][col] = target[index];
        return res;
    }
}
