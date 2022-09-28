package leetcode.lccup2022;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class n3 {
    public static void main(String[] args) {
        new n3().ballGame(4, new String[]{"..E.", ".EOW", "..W."});
    }

    HashMap<String, Integer> memo = new HashMap<>();

    List<int[]> list = new LinkedList<>();
    int[][] d = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    char[][] p;

    public int[][] ballGame(int num, String[] plate) {
        p = new char[plate.length][];
        for (int i = 0; i < plate.length; i++)
            p[i] = plate[i].toCharArray();

        for (int i = 1; i < p.length - 1; i++){
            if (p[i][0] == '.') {
                if (dfs(i, 0, num + 1, 0))
                    list.add(new int[]{i, 0});
            }
            if (p[i][p[0].length - 1] != '.') {
                if (dfs(i, p[0].length - 1, num + 1, 2))
                    list.add(new int[]{i, p[0].length - 1});
            }
        }//for

        for (int i = 1; i < p[0].length - 1; i++){
            if (p[0][i] != '.') {
                if (dfs(0, i, num + 1, 1))
                    list.add(new int[]{0, i});
            }
            if (p[p.length - 1][i] != '.') {
                if (dfs(p.length - 1, i, num + 1, 3))
                    list.add(new int[]{p.length - 1, i});
            }
        }//for

        return list.toArray(new int[0][0]);
    }


    public boolean dfs(int row, int col, int step, int direction){
        if (row < 0 || col < 0 || row == p.length || col == p[0].length || step == 0)
            return false;

        if (p[row][col] == 'O') {
            return true;
        } else if (p[row][col] == 'E') {
            direction = (direction + 1) % 4;
        }else if (p[row][col] == 'W'){
            direction = (direction + 3) % 4;
        }

        return dfs(row + d[direction][0], col + d[direction][1], step - 1, direction);
    }
}
