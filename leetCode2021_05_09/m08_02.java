package leetCode2021_05_09;

import java.util.LinkedList;
import java.util.List;

public class m08_02 {

    public static void main(String[] args) {
        int[][] test = {{0,0,0}, {0,1,0}, {0,0,0}};
        List<List<Integer>> t = pathWithObstacles(test);
        System.out.println(t);
    }
    static public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        LinkedList<List<Integer>> path = new LinkedList<>();

        if(obstacleGrid[0][0] == 1)
            return path;

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row+1][col+1];

        for (int r = 2; r <= row;r++)
            dp[r][0] = -1;
        for (int c = 2; c <= col;c++)
            dp[0][c] = -1;

        for(int r = 1; r <= row;r++){
            for(int c = 1; c <= col; c++) {
                //如果当前格子为障碍
                if (obstacleGrid[r - 1][c - 1] == 1) {
                    dp[r][c] = -1;
                    continue;
                }
                if (dp[r - 1][c] == -1 && dp[r][c - 1] == -1)
                    dp[r][c] = -1;
                else
                    dp[r][c] = 1;
            }
        }

        int r = row ,c = col;

        if(dp[r][c] == -1)
            return path;

        while (r > 1 || c > 1){
            LinkedList<Integer> line = new LinkedList<>();
            if (r-1 >= 1 && dp[r-1][c] == 1) {
                line.add(r-1);
                line.add(c-1);
                path.addFirst(line);
                r = r-1;
            } else if (c-1 >= 1 && dp[r][c-1] == 1) {
                line.add(r-1);
                line.add(c-1);
                path.addFirst(line);
                c = c-1;
            } else
                break;
        }

        if(r > 1 || c > 1)
            path.clear();
        else{
            LinkedList<Integer> line = new LinkedList<>();
            line.add(0);
            line.add(0);
            path.addFirst(line);
        }
        return path;
    }
}
