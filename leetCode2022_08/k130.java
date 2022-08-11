package leetcode.leetCode2022_08;

public class k130 {
    public void solve(char[][] board) {

        for (int i = 0; i < board[0].length; i++){
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }

        for (int i = 1; i < board.length - 1; i++){
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'Z')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

    }

    public void dfs(char[][] board, int row, int col){
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1)
            return;
        else if (board[row][col] == 'X' || board[row][col] == 'Z')
            return;

        board[row][col] = 'Z';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
