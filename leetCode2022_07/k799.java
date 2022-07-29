package leetcode.leetCode2022_07;

import java.util.Arrays;
import java.util.HashMap;

public class k799 {

    public static void main(String[] args) {
        System.out.println(new k799().champagneTower(25, 6 , 1));
    }

    public double champagneTower(int poured, int query_row, int query_glass){
        double[] dp = new double[query_glass + 2];
        double a;
        double b = 0; // namely pre j - 1
        dp[1] = (poured - 1) / 2.0; //存储的时候从1开始代表0， 0位作为防出界
        for (int i = 1; i <= query_row; i++){
            b = 0;
            for (int j = 1; j < query_glass + 2; j++){
                a = dp[j];
                dp[j] = Math.max(b, 0) + Math.max(dp[j], 0);
                dp[j] = (dp[j] - 1)/2;
                b = a;
            }
        }

        if (dp[query_glass + 1] >= 0)
            return 1;
        else
            return dp[query_glass + 1] * 2 + 1;
    }

//    double sum;
//    double[][] memo;
//    public double champagneTower(int poured, int query_row, int query_glass) {
//        this.sum = poured;
//        this.memo = new double[query_row + 1][query_glass + 1];
//        for (double[] t : memo)
//            Arrays.fill(t, -1);
//
//        double ans = reverseDfs(query_row, query_glass);
//        if (ans >= 0)
//            return 1;
//        else{
//            return ans * 2 + 1;
//        }
//    }
//
//    public double reverseDfs(int query_row, int query_glass){
//        if (query_row == 0 && query_glass == 0)
//            return (sum - 1) / 2;
//        //判断是否出界
//        if (query_glass < 0 || query_glass > query_row)
//            return 0;
//
//        if (memo[query_row][query_glass] != -1)
//            return memo[query_row][query_glass];
//
//        double cur_sum = 0;
//        double tmp;
//        tmp = reverseDfs(query_row - 1, query_glass);
//        if (tmp > 0)
//            cur_sum += tmp;
//        tmp = reverseDfs(query_row - 1, query_glass - 1);
//        if (tmp > 0)
//            cur_sum += tmp;
//        memo[query_row][query_glass] = (cur_sum - 1) / 2;
//        return (cur_sum - 1) / 2;
//    }
}
