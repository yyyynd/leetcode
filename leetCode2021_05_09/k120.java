package leetCode2021_05_09;

import java.util.Iterator;
import java.util.List;

public class k120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.get(0) == null)
            return 0;

        int row = triangle.size();
        //其实可以只用了下三角，可以压缩矩阵的
        int[][] dp = new int[row][row];

        if(row == 1)
            return triangle.get(0).get(0);

        Iterator<List<Integer>> listIterator = triangle.listIterator();
        List<Integer> lastList = null;
        //找到最后一层
        while (listIterator.hasNext()){
            lastList = listIterator.next();
        }

        Iterator<Integer> lastListIterator = lastList.listIterator();
        for(int i = 0; i < row; i++)
            dp[row-1][i] = lastListIterator.next();


        for(int i = row-2; i >=0; i--){
            List<Integer> currentRow = triangle.get(i);
            for(int j = 0; j <= i; j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + currentRow.get(j);
            }
        }

        return dp[0][0];
    }
}
