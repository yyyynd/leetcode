package leetCode2021_05_09;

public class k746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[1] = dp[0];
        //这里要注意的是楼顶的概念和在这层的体力是爬到下一层的所需
        for (int i = 2; i <= cost.length; i++)
            dp[i] = Math.min(dp[i-1]+cost[i-1] , dp[i-2]+cost[i-2]);

        return dp[cost.length];
    }
}
