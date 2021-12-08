package leetCode2021_05_09;

public class k198 {

    /**
     * 本质上还是一个求在有i项的情况下最大的组合
     * 个限制条件，即取了某一点后不能再取相邻点这决定了要么我们取i点和i-2项中的最大组合
     * 要么就是不取i点取i-1项组成的最大组合
     */
    public int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length+2];

        for(int i = 2; i < length+2; i++){
            dp[i] = Math.max(dp[i-2] + nums[i-2], dp[i-1]);
        }

        return dp[length+1];
    }
}
