package leetcode.leetCode2022_10;

/**
 * 这是很明显能形成状态转换的问题（几个状态之间可以形成循环的转换）
 * 然后转移方程设计的思路，就是计算每种状态可以从哪些状态转换过来
 *
 * 所以如果以后看到这种状态之间相互转换的题，就应该考虑这种计算状态转换次数的思路
 */
public class k935 {
    public static void main(String[] args) {
        System.out.println(new k935().knightDialer(161));
    }
    public int knightDialer(int n) {
        if (n == 1)
            return 10;
        int mod = (int) 1e9+7;
        long[] memo = new long[]{1,1,1,1};
        for (int i = 1; i < n; i++){
            long tmp = memo[0];
            memo[0] = (memo[1] % mod + memo[2] % mod) %mod;
            memo[1] = 2*tmp % mod;
            long tmp2 = memo[2] ;
            memo[2] = (2*tmp % mod + memo[3] %mod) %mod;
            memo[3] = 2*tmp2 %mod;
        }

        return (int)( (4*memo[0]%mod + 2*memo[1]%mod + 2*memo[2]%mod + memo[3]%mod) %mod);
    }


}
