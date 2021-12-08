package leetCode2021_05_09;

/**
 * 这道回文题和之前的区别是，求的是最长子序列，也就意味着没有连续的要求限制了
 * 当然具体思路还是一样的，利用小部分推导出最终问题答案，依然是动态规划，先求小区域范围内
 * 的最长子序列，然后扩大取值范围通过之前的求解结果推导当前范围的答案
 *
 * 但和子串不同，因为这里是可以不连续的，也就是说不需要s[l]==s[r]这种前提限制了
 *
 * 这里我们同样也是每次循环相当于在之前的基础上添加最左元素和最右元素（虽然在二层循环里这个最左看着是不变的
 * 但实际上相对于[l+1][r]来说，这个l就是新加入的，这个时候我们要考虑的就是是否新的l和r元素是否可以使结果更大了
 * 如果s[l]==s[r]显然是可以的，因为dp[l][r]是之前求值过的更小区域，肯定已经是最优解了
 *
 * 如果不等，则考虑取左或者取右更新结果
 */
public class k516 {

    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];

        for(int l = s.length()-1; l>= 0; l--){
            dp[l][l] = 1;
            for(int r = l+1; r < s.length(); r++){
                if(chars[l] == chars[r])
                    dp[l][r] = dp[l+1][r-1]+2;
                else
                    dp[l][r] = Math.max(dp[l+1][r],dp[l][r-1]);
            }
        }

        return dp[0][s.length()-1];
    }
}
