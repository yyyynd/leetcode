package leetCode2021_05_09;

public class k213 {
    /**
     * 这题相比k198多了一个条件就是这些点是形成了圆环
     * 那么就要考虑一个问题了，怎么处理头尾这两个点的取舍
     * 这里的解决方式是计算两次，一次舍去尾节点，假设会取到头
     * 另一个相反；
     *
     * 那么如果头尾均不取呢，其实根据k198的算法，这种是会考虑进去的，
     * 因为每次我们都会舍去头或者尾，而如果进行k198的算法，留下的头或者尾也是
     * 可能会取不到的，就形成了头尾均不取的情况
     */
    public int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length+1];
        int result_1,result_2;

        if(length == 1)
            return nums[0];

        for(int i = 2; i <= length; i++)
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-2]);
        result_1 = dp[length];

        for(int i = 2; i <= length; i++)
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        result_2 = dp[length];

        return Math.max(result_1,result_2);
    }
}
