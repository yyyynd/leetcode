package leetCode2021_12;

/**
 * 要最后能放置成board所展示的形式需要考虑以下几点
 * 1.起手的人X，也就意味着X的数量必大于等于O的数量，且最多多一个
 * 2.如果有人完成连线要提前结束游戏，这个时候要考虑点的数量（比如O连线了，那么必定是X=O；如果是X，则必定X = O + 1
 *
 *
 * 这个其实写的有问题，比如现在测试的例子就是不能通过的，但lc上通过了，
 * 在o_count == x_count有连线时要考虑，是否XO都是连线状态
 */
public class k794 {
    char winner;

    public static void main(String[] args) {
        System.out.println(new k794().validTicTacToe(new String[]{"OOO","XXX","   "}));
    }
    public boolean validTicTacToe(String[] board) {
        int x_count = 0;
        int o_count = 0;
        char[][] b = new char[3][3];
        for (int i = 0; i < 3; i++){
            b[i] = board[i].toCharArray();
            for(char c : b[i]){
                switch (c){
                    case 'X' : x_count++;
                            break;
                    case 'O' : o_count++;
                            break;
                }//switch
            }//for
        }//for
        //判断数量是否符合
        if(x_count > o_count + 1)
            return false;
        else if(x_count < o_count)
            return false;

        if(checkWinner(b)){
            if(winner == 'X')
                return x_count == o_count + 1;
            return x_count == o_count;
        }

        return true;
    }

    public boolean checkWinner(char[][] board){
        for (int i = 0; i < 3; i++){
            if ( board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != ' ') {
                winner = board[i][0];
                return true;
            }
        }
        for (int i = 0; i < 3; i++){
            if( board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != ' '){
                winner = board[0][i];
                return true;
            }
        }
        if ( board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ') {
            winner = board[0][0];
            return true;
        }
        if ( board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != ' ') {
            winner = board[0][2];
            return true;
        }
        return false;
    }
}
