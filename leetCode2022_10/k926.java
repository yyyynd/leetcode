package leetcode.leetCode2022_10;

/**
 * 如果这个位置置为0对右侧没什么限制，是0和1都可以
 * 但如果置为1的话右侧必须为1
 *
 * 那么根据这个思路设计状态转移方程就很比较明显了
 * 这里我是从后往前，那么置为1的情况只用考虑之前置为1花了多少次数，即 dp1 = dp1 + if cur char is '1'
 * 而置为0的时候就要选择后面全为1和全为0时哪个花费的次数更少了，即dp0 = min(dp1, dp0) + if cur char is '0'
 *
 * 如果是从前往后则上述相反思路即可
 */
public class k926 {
    public static void main(String[] args) {
        System.out.println(new k926().minFlipsMonoIncr("00110"));
    }
    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[s.length()][2];
        char[] str = s.toCharArray();
        int len = s.length();
        dp[len - 1][0] = str[len - 1] == '0' ? 0 : 1;
        dp[len - 1][1] = dp[len - 1][0] == 0 ? 1 : 0;
        for (int i = len - 2; i >= 0; i--){
            int add = str[i] == '0' ? 0 : 1;
            dp[i][0] = Math.min(dp[i+1][0], dp[i+1][1]) + add;
            dp[i][1] = dp[i+1][1] + (add ^ 1);
        }

        return Math.min(dp[0][0], dp[0][1]);
    }

}
