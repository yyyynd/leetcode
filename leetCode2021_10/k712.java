package leetCode2021_10;

/**
 * 状态转移方程
 * dp[i][j]代表，从i位置到结尾的s1子串，j位置到结尾的s2子串，为了使得两个子串相同所需要的删除的
 * 字符的ascii码值的和
 *
 *
 */
public class k712 {
    public int minimumDeleteSum(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[][] dp = new int[str1.length+1][str2.length+1];

        for(int i = str1.length - 1; i >= 0; i--)
            dp[i][str2.length] = dp[i+1][str2.length] + str1[i];

        for(int j = str2.length - 1; j >= 0; j--)
            dp[str1.length][j] = dp[str1.length][j+1] + str2[j];

        for(int i = str1.length-1; i >= 0; i--){
            for (int j = str2.length-1; j >= 0; j--){
                if(str1[i] == str2[j])
                    dp[i][j] = dp[i+1][j+1];
                else
                    dp[i][j] = Math.min(dp[i+1][j] + str1[i], dp[i][j+1] + str2[j]);
            }
        }

        return dp[0][0];
    }
}
