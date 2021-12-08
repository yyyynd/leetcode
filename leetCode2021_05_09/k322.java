package leetCode2021_05_09;

import java.util.Arrays;

public class k322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        if(amount == 0)
            return 0;
        Arrays.sort(coins);
        for(int i = 1; i <= amount; i++){
            if(coins[0] > i)
                continue;
            for(int j = 0; j < coins.length; j++){
                if(coins[j] > i)
                    break;
                //防止只取一个硬币时就无法组合的情况
                if(i != coins[j] && dp[i-coins[j]] == 0)
                    continue;
                dp[i] = Math.min(dp[i-coins[j]] + 1, dp[i] != 0 ? dp[i] : Integer.MAX_VALUE);
            }
        }

        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
