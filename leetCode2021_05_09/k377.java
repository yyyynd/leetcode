package leetCode2021_05_09;

public class k377 {

    public int combinationSum4(int[] nums, int target) {
        if(target == 0)
            return 0;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for (int num : nums) {
                if (num > i)
                    continue;
                dp[i] = dp[i] + dp[i - num];
            }
        }//for

        return dp[target];
    }
}
