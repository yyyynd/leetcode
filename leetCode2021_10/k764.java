package leetCode2021_10;

import java.util.Arrays;
import java.util.HashSet;

public class k764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        //快速查询0点集合
        HashSet<Integer> set = new HashSet<>();
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int[] m : mines)
            set.add(n * m[0] + m[1]);

        int count;
        for(int i = 0; i < n; i++){
            count = 0;
            //首先判断左侧臂长
            for(int j = 0; j < n; j++){
                count = set.contains(n * i + j) ? 0 : count + 1;
                dp[i][j] = count;
            }
            count = 0;
            //再判断右侧臂长
            for(int j = n-1; j >= 0; j--){
                count = set.contains(n * i + j) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j],count);
            }
            count = 0;
            for (int j = 0; j < n; j++){
                count = set.contains(n * j + i) ? 0 : count + 1;
                dp[j][i] = Math.min(dp[j][i],count);
            }

            count = 0;
            for (int j = n-1; j >= 0; j--){
                count = set.contains(n * j + i) ? 0 : count + 1;
                dp[j][i] = Math.min(dp[j][i],count);
                ans = Math.max(dp[j][i],ans);
            }
        }

        return ans;
    }
}
