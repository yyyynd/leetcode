package leetcode.leetCode2022_10;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class k934 {
//    Deque<int[]> edges;
//    int[][] memo;
//    public int shortestBridge(int[][] grid) {
//        this.edges = new LinkedList<>();
//        this.memo = new int[grid.length][grid.length];
//        int[] first = new int[2];
//        boolean flag = true;
//        for (int i = 0; i < grid.length && flag; i++){
//            for (int j = 0; j < grid[0].length && flag; j++){
//                if (grid[i][j] == 1){
//                    first[0] = i;
//                    first[1] = j;
//                    dfsIsland(i,j,grid);
//                    flag = false;
//                }
//            }
//        }//for
//        int ans = Integer.MAX_VALUE;
//        return ans;
//    }
//
//    public void dfsIsland(int row, int col, int[][] gird){
//        if (row < 0 || row == gird.length || col < 0 || col == gird[0].length ||
//                gird[row][col] == 2 || gird[row][col] == 0)
//            return;
//        gird[row][col] = 2;
//        this.edges.add(new int[]{row,col});
//        dfsIsland(row + 1, col, gird);
//        dfsIsland(row - 1, col, gird);
//        dfsIsland(row, col + 1, gird);
//        dfsIsland(row, col - 1, gird);
//    }
//
//    public int bfs(int row, int col, int[][] gird){
//    }
}
