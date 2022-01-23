package leetcode.leetCode2021_05_09;

public class k5 {
    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(new k5().longestPalindrome(s));
    }

    /**
     * 回文串有很明显的动态规划性质（一个大问题可以分解为一步步的小问题）
     * 因为回文的性质就是，如果你去掉头尾，剩下的部分还是一个回文
     * 就可以得出状态转移方程dp[i][j] = d[i+1][j-1](这里dp[i][j]指的是i..j范围是否构成回文串
     *
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        char[] string = s.toCharArray();
        int start = 0, end = 0;

        for(int i = length-1; i >= 0; i--){
            for (int j = i; j < length; j++ ){
                if(string[i] == string[j]){
                    //如果长度为1,2,3直接是回文，长度4及以上才向内状态转移
                    if(j-i+1 <= 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                }
                if(dp[i][j] && j-i+1 > end-start+1){
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start,end+1);
    }
}
