package leetCode2021_05_09;

import java.util.LinkedList;

public class k542 {

    public int[][] updateMatrix(int[][] mat) {
        LinkedList<int[]> list = new LinkedList<>();
        for(int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0)
                    list.add(new int[]{i,j});
                else
                    mat[i][j] = -1;
            }
        }

        int[] xDirection = {-1,1,0,0};
        int[] yDirection = {0,0,-1,1};

        while (!list.isEmpty()){
            int[] curPoint = list.poll();
            int x = curPoint[0];
            int y = curPoint[1];
            for(int i = 0; i < 4; i++){
                int cur_x = x + xDirection[i];
                int cur_y = y + yDirection[i];

                if( cur_x >= 0 && cur_y >= 0 &&  cur_x < mat.length && cur_y < mat[0].length
                        && mat[cur_x][cur_y] == -1) {
                    mat[cur_x][cur_y] = mat[x][y] + 1;
                    list.add(new int[]{cur_x,cur_y});
                }
            }
        }

        return mat;
    }
}
